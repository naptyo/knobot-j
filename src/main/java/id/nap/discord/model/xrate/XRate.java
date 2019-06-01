package id.nap.discord.model.xrate;

public class XRate {
	private String base;
	private Rate rates;
	private String date;
	
	public XRate() {
		super();
	}

	public XRate(String base, Rate rates, String date) {
		super();
		this.base = base;
		this.rates = rates;
		this.date = date;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}
	
	public Rate getRates() {
		return rates;
	}

	public void setRates(Rate rates) {
		this.rates = rates;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
