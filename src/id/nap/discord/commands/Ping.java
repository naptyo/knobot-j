package id.nap.discord.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Ping extends Command {
	private static final Logger logger = LogManager.getLogger(Ping.class);
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		logger.info(
				event.getAuthor().getName() 
				+ " sent " 
				+ event.getMessage().getContentDisplay()
				+ " in "
				+ event.getChannel().getName());
		
		sendMessage(event, "Pong!");
	}

	@Override
	public String getCommand() {
		return "!ping";
	}
	
}
