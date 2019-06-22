package id.nap.discord.model.wordnik;

public class Example {
	private String url;
	private String title;
	private String text;
	private long id;
	
	public Example() {
		super();
	}

	public Example(String url, String title, String text, long id) {
		super();
		this.url = url;
		this.title = title;
		this.text = text;
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
