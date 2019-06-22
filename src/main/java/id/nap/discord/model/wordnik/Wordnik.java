package id.nap.discord.model.wordnik;

import java.util.List;

public class Wordnik {
	private String _id;
	private String word;
	private Provider contentProvider;
	private List<Definition> definitions;
	private String publishDate;
	private List<Example> examples;
	private String ppd;
	private String note;
	private String htmlExtra;
	
	public Wordnik() {
		super();
	}

	public Wordnik(String _id, String word, Provider contentProvider, List<Definition> definitions, String publishDate,
			List<Example> examples, String ppd, String note, String htmlExtra) {
		super();
		this._id = _id;
		this.word = word;
		this.contentProvider = contentProvider;
		this.definitions = definitions;
		this.publishDate = publishDate;
		this.examples = examples;
		this.ppd = ppd;
		this.note = note;
		this.htmlExtra = htmlExtra;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Provider getContentProvider() {
		return contentProvider;
	}

	public void setContentProvider(Provider contentProvider) {
		this.contentProvider = contentProvider;
	}

	public List<Definition> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<Definition> definitions) {
		this.definitions = definitions;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public List<Example> getExamples() {
		return examples;
	}

	public void setExamples(List<Example> examples) {
		this.examples = examples;
	}

	public String getPpd() {
		return ppd;
	}

	public void setPpd(String ppd) {
		this.ppd = ppd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getHtmlExtra() {
		return htmlExtra;
	}

	public void setHtmlExtra(String htmlExtra) {
		this.htmlExtra = htmlExtra;
	}
}
