package id.nap.discord.commands;

import java.time.LocalDateTime;

import id.nap.discord.ConfigManager;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Holiday extends Command {
	private static final String ENDPOINT_URL = "https://calendarific.com/api/v2/holidays";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		logCommand(event, args);
		StringBuilder builder = new StringBuilder(ENDPOINT_URL);
		String key = getCalendarKey();
		
		if (key != null) {
			builder.append("?&api_key=" + key);
			builder.append("&country=ID");
		} else {
			sendMessage(event, "Unable to retrieve public holday(s).");
			return;
		}
		
		if (args.length < 2) {
			builder.append("&year="+LocalDateTime.now().getYear());
			sendMessage(event, builder.toString());
		}
	}

	@Override
	public String getCommand() {
		return "!holidays";
	}
	
	private String getCalendarKey() {
		return ConfigManager.getInstance().getConfig().getCalendarToken();
	}
}
