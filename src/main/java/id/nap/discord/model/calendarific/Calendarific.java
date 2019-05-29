package main.java.id.nap.discord.model.calendarific;

public class Calendarific {
	private Meta meta;
	private Response response;
	
	public Calendarific() {
		super();
	}

	public Calendarific(Meta meta, Response response) {
		super();
		this.meta = meta;
		this.response = response;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
