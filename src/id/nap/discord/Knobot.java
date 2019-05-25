package id.nap.discord;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;

public class Knobot {
	
	public static void main(String[] args) throws LoginException {
		String token = "";
		JDABuilder builder = new JDABuilder(AccountType.BOT);
		builder.setToken(token);
		builder.build();
	}

}
