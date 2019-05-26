package id.nap.discord.commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		if (event.getAuthor().isBot()) {
			return;
		}

		System.out.println("Message received: " 
				+ event.getAuthor().getName()
				+ event.getMessage().getContentDisplay());
	}
	
}
