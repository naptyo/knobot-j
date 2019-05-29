package main.java.id.nap.discord;

import javax.security.auth.login.LoginException;

import main.java.id.nap.discord.commands.Ping;
import main.java.id.nap.discord.commands.Holiday;
import main.java.id.nap.discord.commands.WordOfTheDay;
import main.java.id.nap.discord.model.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Knobot {
	
	public static final int NO_CONFIG_FOUND = 501;
	public static final int IO_ERROR = 502;
	public static final int BAD_UNICODE_ESCAPE = 503;
	
	public static void main(String[] args) throws LoginException {
		Config config = ConfigManager.getInstance().getConfig();
		
		JDABuilder builder = new JDABuilder(AccountType.BOT).setToken(config.getDiscordToken());
		
		builder.addEventListener(new Ping());
		builder.addEventListener(new WordOfTheDay());
		builder.addEventListener(new Holiday());
		
		builder.build();
	}
}
