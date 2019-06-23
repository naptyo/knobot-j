package id.nap.discord.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import id.nap.discord.ConfigManager;
import id.nap.discord.model.wordnik.Wordnik;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class WOTDCommand extends Command {

	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		String key = getWordnikKey();
		
		if (key == null) {
			sendMessage(event, "Unable to receive word of the day.");
			return;
		}
		
		Wordnik wotd = getWordOfTheDay(key);
		
		System.out.println(wotd.get_id());
	}
	
	private Wordnik getWordOfTheDay(String key) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("https://api.wordnik.com/words.json/wordOfTheDay");
		baseTarget = baseTarget.queryParam("api_key", key);
		baseTarget = baseTarget.queryParam("date", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		
		return baseTarget
				.request(MediaType.APPLICATION_JSON)
				.get(Wordnik.class);
	}
	
	private String getWordnikKey() {
		return ConfigManager.getInstance().getConfig().getWordnikToken();
	}
	
	@Override
	public String getCommand() {
		return "!wotd";
	}

	@Override
	public boolean isDisasbled() {
		return false;
	}
}
