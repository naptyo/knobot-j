package id.nap.discord.model;

public class Config {
	private String discordToken;
	private String calendarToken;
	private String wordnikToken;
	
	public Config() {
		super();
	}

	public Config(String discordToken, String calendarToken, String wordnikToken) {
		super();
		this.discordToken = discordToken;
		this.calendarToken = calendarToken;
		this.wordnikToken = wordnikToken;
	}

	public String getDiscordToken() {
		return discordToken;
	}

	public void setDiscordToken(String discordToken) {
		this.discordToken = discordToken;
	}

	public String getCalendarToken() {
		return calendarToken;
	}

	public void setCalendarToken(String calendarToken) {
		this.calendarToken = calendarToken;
	}

	public String getWordnikToken() {
		return wordnikToken;
	}

	public void setWordnikToken(String wordnikToken) {
		this.wordnikToken = wordnikToken;
	}
}
