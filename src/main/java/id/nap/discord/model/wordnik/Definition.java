package id.nap.discord.model.wordnik;

public class Definition {
	private String source;
	private String text;
	private String note;
	private String partOfSpeech;
	
	public Definition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Definition(String source, String text, String note, String partOfSpeech) {
		super();
		this.source = source;
		this.text = text;
		this.note = note;
		this.partOfSpeech = partOfSpeech;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPartOfSpeech() {
		return partOfSpeech;
	}

	public void setPartOfSpeech(String partOfSpeech) {
		this.partOfSpeech = partOfSpeech;
	}
}
