package id.nap.discord.model.calendarific;

public class Date {
	private String iso;
	private Datetime datetime;
	private Timezone timezone;
	
	public Date() {
		super();
	}

	public Date(String iso, Datetime datetime, Timezone timezone) {
		super();
		this.iso = iso;
		this.datetime = datetime;
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return datetime.getDay()+"/"+datetime.getMonth()+"/"+datetime.getYear();
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public Datetime getDatetime() {
		return datetime;
	}

	public void setDatetime(Datetime datetime) {
		this.datetime = datetime;
	}

	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}
}
