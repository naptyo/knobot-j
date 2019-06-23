package id.nap.discord.commands;

import id.nap.discord.Knobot;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ShutDownCommand extends Command {
	
	private final static String USER_ID = "170384700433629184";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		if (event.getAuthor().getId().equals(USER_ID)) {
			sendMessage(event, "Shutting down...");
			System.out.println("Bot has shut down.");
			System.exit(Knobot.SHUTDOWN);
		}
	}

	@Override
	public String getCommand() {
		return "!shutdown";
	}

	@Override
	public boolean isDisabled() {
		return false;
	}
	
}
