package it.polito.bigdata.spark.example;

public class timeDateCri {

	private int time;
	private String date;
	private double criticality;
	
	public timeDateCri(int time, String date, double criticality) {
		this.time = time;
		this.date = date;
		this.criticality = criticality;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getDate() {
		return date;
	}
	
	public double getCri() {
		return criticality;
	}
}
