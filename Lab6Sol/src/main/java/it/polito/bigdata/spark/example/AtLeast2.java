package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function;

import scala.Tuple2;

@SuppressWarnings("serial")
public class AtLeast2 implements Function<Tuple2<String, Integer>, Boolean> {

	@Override
	public Boolean call(Tuple2<String, Integer> t) throws Exception {
		// t_2() contains the number of occurrencies of the current pair of
		// products
		return t._2() > 1;
	}

}
