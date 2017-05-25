package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function;

import scala.Tuple2;

public class ToKML implements Function<Tuple2<String, Tuple2<timeDateCri, String>>, String> {

	@Override
	public String call(Tuple2<String, Tuple2<timeDateCri, String>> arg0) throws Exception {
		
		String result = "<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>"
			+ "<Placemark><name>" + arg0._1 + "</name><ExtendedData><Data"
			+ "name=\"DayWeek\"><value>"+ DateTool.DayOfTheWeek(arg0._2._1.getDate()) +"</value></Data><Data"
			+ "name=\"Hour\"><value>"+ arg0._2._1.getTime() +"</value></Data><Data"
			+ "name=\"Criticality\"><value>" + arg0._2._1.getCri() + "</value></Data></ExtendedData><"
			+ "Point><coordinates>"+ arg0._2._2 +"</coordinates></Point></Placemark>"
		    + "</Document></kml>";
		return result;
	}

}
