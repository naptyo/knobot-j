package id.nap.discord.commands;

import java.time.LocalDateTime;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Holiday extends Command {

	private static final String ENDPOINT_URL = "https://calendarific.com/api/v2/holidays";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		StringBuilder builder = new StringBuilder(ENDPOINT_URL);
		
		if (getCalendarificKey() != null) {
			builder.append("?&api_key" + getCalendarificKey());
			builder.append("&country=ID");
		} else {
			sendMessage(event, "Unable to retrieve public holday(s).");
			return;
		}
		
		if (args[1] == null || args[1].isEmpty() ) {
			builder.append("&year="+LocalDateTime.now().getYear());
			sendMessage(event, builder.toString());
		}
	}

	@Override
	public void logCommand(MessageReceivedEvent event, String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand() {
		return "!holidays";
	}
	
	private String getCalendarificKey() {
		return System.getenv("CALENDARIFIC_TOKEN");
	}

}
