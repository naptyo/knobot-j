package id.nap.discord.commands;

import java.awt.Color;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import id.nap.discord.ConfigManager;
import id.nap.discord.model.wordnik.Wordnik;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
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
		
		sendMessage(event, buildMessage(wotd));
	}
	
	private Message buildMessage(Wordnik wotd) {
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setTitle(wotd.getWord());
		embed.setDescription(wotd.getDefinitions().get(0).getPartOfSpeech());
		
		embed.addField("Definition", wotd.getDefinitions().get(0).getText(), false);
		embed.addField("Example", wotd.getExamples().get(0).getText(), false);
		
		embed.setColor(Color.blue);
		embed.setTimestamp(Instant.now());
		
		return new MessageBuilder().setEmbed(embed.build()).build();
	}
	
	private Wordnik getWordOfTheDay(String key) {
		Client client = ClientBuilder.newClient();
		WebTarget baseTarget = client.target("https://api.wordnik.com/v4/words.json/wordOfTheDay");
		baseTarget = baseTarget.queryParam("date", LocalDate.now().format(DateTimeFormatter.ISO_DATE).toString());
		baseTarget = baseTarget.queryParam("api_key", key);
		
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
	public boolean isDisabled() {
		return false;
	}
}
