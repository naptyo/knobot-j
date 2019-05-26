package id.nap.discord;

import javax.security.auth.login.LoginException;

import id.nap.discord.commands.Ping;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Knobot {
	
	public static void main(String[] args) throws LoginException {
		String token = "";
		JDABuilder builder = new JDABuilder(AccountType.BOT).setToken(token);
		
		builder.addEventListener(new Ping());
		
		builder.build();
	}

}
