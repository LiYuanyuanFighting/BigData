package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function;

public class Percentage implements Function<Count, Double> {

	@Override
	public Double call(Count arg0) throws Exception {
		
		return new Double((double)arg0.numCriticalReadings/(double)arg0.numReadings);
	}

}
