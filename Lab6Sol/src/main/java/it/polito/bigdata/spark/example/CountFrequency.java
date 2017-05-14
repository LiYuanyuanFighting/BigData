package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.function.Function2;

@SuppressWarnings("serial")
public class CountFrequency implements Function2<Integer, Integer, Integer> {

	@Override
	public Integer call(Integer count1, Integer count2) throws Exception {
		return new Integer(count1 + count2);
	}

}
