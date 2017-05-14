package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

@SuppressWarnings("serial")
public class PairUserIdProductID implements PairFunction<String, String, String> {

	@Override
	public Tuple2<String, String> call(String s) {
		String[] features = s.split(",");

		return new Tuple2<String, String>(features[2], features[1]);
	}

}
