package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class changePair implements PairFunction<Tuple2<String, Double>, String, timeDateCri> {

	@Override
	public Tuple2<String, timeDateCri> call(Tuple2<String, Double> arg0) throws Exception {
		
		String[] fields = arg0._1.split("_");
		return new Tuple2<String, timeDateCri>(fields[0], new timeDateCri(Integer.parseInt(fields[2]), fields[1], arg0._2));
	}

}
