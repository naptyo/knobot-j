package id.nap.discord.model.calendarific;

public class Timezone {
	private String offset;
	private String zoneabb;
	private int zoneoffset;
	private int zonedst;
	private int zonetotaloffset;
	
	public Timezone() {
		super();
	}

	public Timezone(String offset, String zoneabb, int zoneoffset, int zonedst, int zonetotaloffset) {
		super();
		this.offset = offset;
		this.zoneabb = zoneabb;
		this.zoneoffset = zoneoffset;
		this.zonedst = zonedst;
		this.zonetotaloffset = zonetotaloffset;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getZoneabb() {
		return zoneabb;
	}

	public void setZoneabb(String zoneabb) {
		this.zoneabb = zoneabb;
	}

	public int getZoneoffset() {
		return zoneoffset;
	}

	public void setZoneoffset(int zoneoffset) {
		this.zoneoffset = zoneoffset;
	}

	public int getZonedst() {
		return zonedst;
	}

	public void setZonedst(int zonedst) {
		this.zonedst = zonedst;
	}

	public int getZonetotaloffset() {
		return zonetotaloffset;
	}

	public void setZonetotaloffset(int zonetotaloffset) {
		this.zonetotaloffset = zonetotaloffset;
	}
}
