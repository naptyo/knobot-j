package main.java.id.nap.discord.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public abstract class Command extends ListenerAdapter{
	public abstract void onCommand(MessageReceivedEvent event, String[] args);
	public abstract String getCommand();
	
	protected final static Logger LOGGER = LogManager.getLogger(Command.class);
	
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}
		
		if (isCommand(event.getMessage())) {
			logCommand(event);
			onCommand(event, commandArguments(event.getMessage()));
		}
	}
	
	protected void logCommand(MessageReceivedEvent event) {
		LOGGER.info(
				event.getAuthor().getName()
				+ " sent "
				+ event.getMessage().getContentDisplay()
				+ " in "
				+ event.getChannel().getName());
	}
	
	protected boolean isCommand(Message message) {
		return getCommand().equalsIgnoreCase(commandArguments(message)[0]);
	}
	
	protected String[] commandArguments(Message message) {
		return commandArguments(message.getContentDisplay());
	}
	
	protected String[] commandArguments(String message) {
		return message.split(" ");
	}
	
	protected Message sendMessage(MessageReceivedEvent event, String message) {
		return sendMessage(event, new MessageBuilder().append(message).build());
	}
	
	protected Message sendMessage(MessageReceivedEvent event, Message message) {
		if (event.isFromType(ChannelType.PRIVATE)) {
			return event.getPrivateChannel().sendMessage(message).complete();
		} else {
			return event.getTextChannel().sendMessage(message).complete();
		}
	}
}
