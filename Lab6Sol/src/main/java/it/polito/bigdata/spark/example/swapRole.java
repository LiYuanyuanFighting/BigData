package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

@SuppressWarnings("serial")
public class swapRole implements PairFunction<Tuple2<String, Integer>, Integer, String> {

	@Override
	public Tuple2<Integer, String> call(Tuple2<String, Integer> ProductsFrequency) throws Exception {
		return new Tuple2<Integer,String>(ProductsFrequency._2(), ProductsFrequency._1());
	}

}
