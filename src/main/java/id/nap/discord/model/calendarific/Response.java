package main.java.id.nap.discord.model.calendarific;

import java.util.List;

public class Response {
	private List<Holiday> holidays;

	public Response() {
		super();
	}

	public Response(List<Holiday> holidays) {
		super();
		this.holidays = holidays;
	}

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}
}
