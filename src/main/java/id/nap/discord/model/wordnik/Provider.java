package id.nap.discord.model.wordnik;

public class Provider {
	private String name;
	private int id;
	
	public Provider() {
		super();
	}

	public Provider(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
