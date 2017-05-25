package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class StaLocationPair implements PairFunction<String, String, String> {

	@Override
	public Tuple2<String, String> call(String line) throws Exception {
		// if (line.startsWith("id"))
		//	return null; // null pointer exception?
		String[] fields = line.split("\\t");
		return new Tuple2(fields[0], fields[1]+","+fields[2]);
	}

}
