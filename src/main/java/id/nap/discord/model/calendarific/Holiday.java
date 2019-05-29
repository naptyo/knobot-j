package id.nap.discord.model.calendarific;

public class Holiday {
	private String name;
	private String description;
	private Date date;
	private String[] type;
	private String locations;
	private String states;
	
	public Holiday() {
		super();
	}

	public Holiday(String name, String description, Date date, String[] type, String locations, String states) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.type = type;
		this.locations = locations;
		this.states = states;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}
}
