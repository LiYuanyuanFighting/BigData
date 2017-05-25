package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.PairFunction;

import scala.Tuple2;

public class StationTimePair implements PairFunction<String, String, Count> {

	@Override
	public Tuple2<String, Count> call(String line) throws Exception {
String[] fields = line.split("\\t");
		
		// if free_slot = 0, then record with 1
		if (Integer.parseInt(fields[3])==0) {
			String[] dateTime = fields[1].split(" ");
			String dayOfTheWeek = DateTool.DayOfTheWeek(dateTime[0]); // cz only need the day of the week 
			String hour = dateTime[1].replaceAll(":.*", "");
			return new Tuple2<String, Count>(new String(fields[0]+"_"+dayOfTheWeek+"_"+hour), new Count(1, 1));
		}
		String[] dateTime = fields[1].split(" ");
		String dayOfTheWeek = DateTool.DayOfTheWeek(dateTime[0]); // cz only need the day of the week 
		String hour = dateTime[1].replaceAll(":.*", "");
		return new Tuple2<String, Count>(new String(fields[0]+"_"+dayOfTheWeek+"_"+hour), new Count(1, 0));
	}

}
