package id.nap.discord.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Ping extends Command {
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		logCommand(event, args);
		sendMessage(event, "Pong!");
	}

	@Override
	public String getCommand() {
		return "!ping";
	}

	@Override
	public void logCommand(MessageReceivedEvent event, String[] args) {
		LOGGER.info(
				event.getAuthor().getName()
				+ " sent "
				+ event.getMessage().getContentDisplay()
				+ " in "
				+ event.getChannel().getName());
	}
	
}
