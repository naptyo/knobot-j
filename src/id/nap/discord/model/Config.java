package id.nap.discord.model;

public class Config {
	private String discordToken;
	private String calendarToken;
	
	public Config() {
		super();
	}

	public Config(String discordToken, String calendarToken) {
		super();
		this.discordToken = discordToken;
		this.calendarToken = calendarToken;
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
}
