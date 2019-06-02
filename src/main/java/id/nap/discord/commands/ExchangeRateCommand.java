package id.nap.discord.commands;

import java.awt.Color;
import java.time.Instant;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import id.nap.discord.model.xrate.XRate;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ExchangeRateCommand extends Command {
	private static final String TITLE = "Exchange Rate";
	private static final String DESCRIPTION = "Latest (approximate) rate.";
	private static final String FOOTER = "fetched from https://exchangeratesapi.io";
	private static final String ENDPOINT_URL = "https://api.exchangeratesapi.io/latest?base=USD&symbols=IDR";
	
	@Override
	public void onCommand(MessageReceivedEvent event, String[] args) {
		sendMessage(event, buildMessage(getRate()));
	}

	@Override
	public String getCommand() {
		return "!kurs";
	}

	@Override
	public boolean isDisasbled() {
		return true;
	}
	
	private Message buildMessage(XRate rate) {
		EmbedBuilder embed = new EmbedBuilder();
		
		embed.setTitle(TITLE);
		embed.setDescription(DESCRIPTION);
		embed.setColor(Color.green);
		embed.setFooter(FOOTER, "https://exchangeratesapi.io/favicon.ico");
		embed.setTimestamp(Instant.now());
		
		embed.addField(rate.getBase(), "1", true);
		embed.addField("IDR", Long.toString(rate.getRates().getIDR()), true);
		
		return new MessageBuilder().setEmbed(embed.build()).build();
	}
	
	private XRate getRate() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(ENDPOINT_URL);
		
		return target
				.request(MediaType.APPLICATION_JSON)
				.get(XRate.class);
	}
}
