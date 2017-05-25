package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function;

import scala.Tuple2;

public class CriticalPercent implements Function<Tuple2<String, Double>, Boolean> {

	private static final long serialVersionUID = 1L;
	private double threshold;
	
	public CriticalPercent(double threshold) {
		this.threshold = threshold;
	}
	@Override
	public Boolean call(Tuple2<String, Double> arg0) throws Exception {
		double value = arg0._2.doubleValue();
		if (value > threshold)
			return true;
		return false;
	}

}
