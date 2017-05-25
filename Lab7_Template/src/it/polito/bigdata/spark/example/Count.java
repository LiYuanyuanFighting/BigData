package it.polito.bigdata.spark.example;

public class Count {

	public int numReadings;
	public int numCriticalReadings;
	
	public Count(int num, int numCritical)
	{
		this.numReadings = num;
		this.numCriticalReadings = numCritical;
	}
}
