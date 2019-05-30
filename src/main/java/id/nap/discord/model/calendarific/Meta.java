package id.nap.discord.model.calendarific;

public class Meta {
	private int code;
	private String error_type;
	private String error_detail;
	
	public Meta() {
		super();
	}

	public Meta(int code, String error_type, String error_detail) {
		super();
		this.code = code;
		this.error_type = error_type;
		this.error_detail = error_detail;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getError_type() {
		return error_type;
	}

	public void setError_type(String error_type) {
		this.error_type = error_type;
	}

	public String getError_detail() {
		return error_detail;
	}

	public void setError_detail(String error_detail) {
		this.error_detail = error_detail;
	}
}
