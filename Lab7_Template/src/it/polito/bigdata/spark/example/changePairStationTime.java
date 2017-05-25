package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class changePairStationTime implements PairFunction<Tuple2<StationTime, Double>, String, timeDateCri> {

	@Override
	public Tuple2<String, timeDateCri> call(Tuple2<StationTime, Double> arg0) throws Exception {
		
		System.out.println("time is " + arg0._1.getTime());
		return new Tuple2<String, timeDateCri>(arg0._1.getStationId(), new timeDateCri(Integer.parseInt(arg0._1.getTime()), arg0._1.getDate(), arg0._2));
	}

}
