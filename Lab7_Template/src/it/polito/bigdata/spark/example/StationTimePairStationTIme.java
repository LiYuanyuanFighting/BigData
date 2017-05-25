package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class StationTimePairStationTIme implements PairFunction<String, StationTime, Count> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Tuple2<StationTime, Count> call(String line) throws Exception {
		String[] fields = line.split("\\t");
		
		// if free_slot = 0, then record with 1
		if (Integer.parseInt(fields[3])==0) {
			String[] dateTime = fields[1].split(" ");
			String hour = dateTime[1].replaceAll(":.*", "");
			return new Tuple2<StationTime, Count>(new StationTime(fields[0], dateTime[0], hour), new Count(1, 1));
		}
		String[] dateTime = fields[1].split(" ");
		String hour = dateTime[1].replaceAll(":.*", "");
		return new Tuple2<StationTime, Count>(new StationTime(fields[0], dateTime[0], hour), new Count(1, 0));
	}

}
