package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function2;

public class Sum implements Function2<Count, Count, Count> {

	@Override
	public Count call(Count value1, Count value2) throws Exception {
		
		return new Count(value1.numReadings+value2.numReadings, 
				value1.numCriticalReadings+value2.numCriticalReadings);
	}

}
