package id.nap.discord.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class PublicHoliday extends Command {

	private static final String ENDPOINT_URL = "https://calendarific.com/api/v2";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logCommand(MessageReceivedEvent event, String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCommand() {
		return "!holidays";
	}

}
