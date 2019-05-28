package id.nap.discord.commands;

import java.text.DateFormatSymbols;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import id.nap.discord.ConfigManager;
import id.nap.discord.model.calendarific.Calendarific;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Holiday extends Command {
	private static final String ENDPOINT_URL = "https://calendarific.com/api/v2/holidays";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		logCommand(event, args);
		StringBuilder url = new StringBuilder(ENDPOINT_URL);
		String key = getCalendarKey();
		
		if (key != null) {
			url.append("?&api_key=" + key);
			url.append("&country=ID");
		} else {
			sendMessage(event, "Unable to retrieve data.");
			return;
		}
		
		Calendarific dates = getDates(url.toString(), args);
		
		if (dates == null) {
			sendMessage(event, "Invalid arguments.");
		}
		
		if (dates.getResponse().getHolidays().size() > 0) {
			MessageBuilder builder = new MessageBuilder();
			
			int i = 1;
			
			for (id.nap.discord.model.calendarific.Holiday holiday : dates.getResponse().getHolidays()) {
				List<String> holidayType = Arrays.asList(holiday.getType());
				
				if (holidayType.contains("National holiday") || holidayType.contains("Observance")) {
					if(holiday.getName().contains("Diwali")) {
						continue;
					}
					
					builder.append(i + ". " + holiday.getName() +" "+ holiday.getDate().toString() + "\n");
					i++;
				}
			}
			
			sendMessage(event, builder.build());
			return;
		}
		
		sendMessage(event, "No holiday(s) in " + new DateFormatSymbols().getMonths()[Integer.parseInt(args[2])-1] + " " + args[1] + ".");
	}

	@Override
	public String getCommand() {
		return "!holidays";
	}
	
	private Calendarific getDates(String url, String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target(url);
		
		if (args.length == 1) {
			baseTarget = baseTarget.queryParam("year", LocalDateTime.now().getYear());
		} 
		
		if (args.length >= 2) {
			int year = Integer.parseInt(args[1]);
			
			if (year > 2049) {
				return null;
			}
			
			baseTarget = baseTarget.queryParam("year", year);
		}
		
		if (args.length >= 3) {
			int month = Integer.parseInt(args[2]);
			
			if (month < 1 || month > 12) {
				return null;
			}
			
			baseTarget = baseTarget.queryParam("month", month);
		}
		
		if (args.length == 4) {
			int day = Integer.parseInt(args[3]);
			
			if (day < 1 || day > 31) {
				return null;
			}
			
			baseTarget = baseTarget.queryParam("day", day);
		}
		
		return baseTarget
				.request(MediaType.APPLICATION_JSON)
				.get(Calendarific.class);
	}
	
	private String getCalendarKey() {
		return ConfigManager.getInstance().getConfig().getCalendarToken();
	}
}
