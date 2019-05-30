package id.nap.discord;

import javax.security.auth.login.LoginException;

import id.nap.discord.commands.HolidayCommand;
import id.nap.discord.commands.PingCommand;
import id.nap.discord.commands.WOTDCommand;
import id.nap.discord.model.Config;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;

public class Knobot {
	
	public static final int NO_CONFIG_FOUND = 501;
	public static final int IO_ERROR = 502;
	public static final int BAD_UNICODE_ESCAPE = 503;
	
	public static void main(String[] args) throws LoginException {
		Config config = ConfigManager.getInstance().getConfig();
		
		JDABuilder builder = new JDABuilder(AccountType.BOT).setToken(config.getDiscordToken());
		
		builder.addEventListener(new PingCommand());
		builder.addEventListener(new WOTDCommand());
		builder.addEventListener(new HolidayCommand());
		
		builder.setGame(Game.playing("in 127.0.0.1"));
		
		builder.build();
	}
}
