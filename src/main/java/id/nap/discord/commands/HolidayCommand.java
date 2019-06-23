package id.nap.discord.commands;

import java.awt.Color;
import java.text.DateFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import id.nap.discord.ConfigManager;
import id.nap.discord.model.HolidayArguments;
import id.nap.discord.model.calendarific.Calendarific;
import id.nap.discord.model.calendarific.Holiday;
import id.nap.discord.model.calendarific.Meta;
import id.nap.discord.model.calendarific.Response;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class HolidayCommand extends Command {
	private static final String TITLE = "Holidays";
	private static final String DESCRIPTION_HOLIDAYS = "Indonesian public holidays.";
	private static final String DESCRIPTION_NO_HOLIDAYS = "No holiday(s) found.";
	private static final String FOOTER = "fetched from https://calendarific.com";
	private static final String ENDPOINT_URL = "https://calendarific.com/api/v2/holidays";
	private static final String COUNTRY = "ID";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		String key = getCalendarKey();
		
		if (key == null) {
			sendMessage(event, "Unable to retrieve data.");
			return;
		}
		
		Calendarific dates = getDates(key, args);
		Meta meta = dates.getMeta();
		Response response = dates.getResponse();
		
		if (isResponseError(meta)) {
			sendMessage(event, meta.getError_detail().substring(0, meta.getError_detail().indexOf(".")) + ".");
			return;
		} else if (response.getHolidays().size() < 0) {
			sendMessage(event, "No holiday(s) in " + new DateFormatSymbols().getMonths()[Integer.parseInt(args[2])-1] + " " + args[1] + ".");
			return;
		}
		
		sendMessage(event, buildMessage(response.getHolidays()));
	}

	@Override
	public String getCommand() {
		return "!holidays";
	}

	@Override
	public boolean isDisabled() {
		return false;
	}
	
	private Message buildMessage(List<Holiday> holidays) {
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setTitle(TITLE);
		embed.setColor(Color.red);
		embed.setFooter(FOOTER, "https://calendarific.com/favicon/favicon-16x16.png");
		embed.setTimestamp(Instant.now());
		
		if (holidays.size() == 0) {
			embed.setDescription(DESCRIPTION_NO_HOLIDAYS);
		} else {
			embed.setDescription(DESCRIPTION_HOLIDAYS);
			
			for (Holiday holiday : holidays) {
				List<String> holidayType = Arrays.asList(holiday.getType());
				
				if (holidayType.contains("National holiday") || holidayType.contains("Observance")) {
					if (holiday.getName().contains("Diwali")) {
						continue;
					}
					
					embed.addField(holiday.getDate().toString(), holiday.getName(), false);
				}
			}
		}
		
		return new MessageBuilder().setEmbed(embed.build()).build();
	}
	
	private boolean isResponseError(Meta meta) {
		boolean isError = false;
		
		if (meta.getError_type() != null) {
			isError = true;
		}
		
		return isError;
	}
	
	private HolidayArguments filterArguments(int[] args) {
		HolidayArguments arguments = new HolidayArguments();
		
		if (args[0] > LocalDate.now().getYear()+1) {
			arguments.setYear(3000);
			return arguments;
		}
		
		switch (args.length) {
			case 1:
				arguments.setYear(args[0]);
				break;
			case 2:
				arguments.setYear(args[0]);
				arguments.setMonth(args[1]);
				break;
			case 3:
				arguments.setYear(args[0]);
				arguments.setMonth(args[1]);
				arguments.setDay(args[2]);
				break;
			default:
				arguments.setYear(LocalDate.now().getYear());
				break;
		}
		
		return arguments;
	}
	
	private int[] parseArguments(String[] args) {
		List<Integer> intArgs = new ArrayList<>();
		
		for (int i = 1; i < args.length; i++) {
			intArgs.add(Integer.parseInt(args[i]));
		}
		
		return intArgs.stream().mapToInt(i->i).toArray();
	}
	
	private Calendarific getDates(String key, String[] args) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target(ENDPOINT_URL);
		baseTarget = baseTarget.queryParam("api_key", key);
		baseTarget = baseTarget.queryParam("country", COUNTRY);
		
		if (args.length == 1) {
			baseTarget = baseTarget.queryParam("year", LocalDate.now().getYear());
		} else {
			HolidayArguments arguments = filterArguments(parseArguments(args));
			
			if (arguments.getYear() == 3000) {
				Meta meta = new Meta(0, "call failed", "Unable to retrieve holidays that are 2 years ahead from current year.");
				return new Calendarific(meta, null);
			}
			
			baseTarget = baseTarget.queryParam("year", arguments.getYear());
			baseTarget = (arguments.getMonth() != 0) ? baseTarget.queryParam("month", arguments.getMonth()) : baseTarget;
			baseTarget = (arguments.getDay() != 0) ? baseTarget.queryParam("day", arguments.getDay()) : baseTarget;
		}
		
		return baseTarget
				.request(MediaType.APPLICATION_JSON)
				.get(Calendarific.class);
	}
	
	private String getCalendarKey() {
		return ConfigManager.getInstance().getConfig().getCalendarToken();
	}
}
