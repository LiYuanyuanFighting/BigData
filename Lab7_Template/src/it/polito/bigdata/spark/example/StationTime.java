package it.polito.bigdata.spark.example;

public class StationTime {

	private String StationId;
	private String date;
	private String time;
	
	public StationTime(String StationId, String date, String time) {
		this.StationId = StationId;
		this.time = time;
		this.date = date;
	}
	
	public String getStationId() {
		return StationId;
	}
	
	public String getTime() {
		return time;
	}
	public String getDate() {
		return date;
	}
}
