package it.polito.bigdata.spark.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.function.PairFlatMapFunction;

import scala.Tuple2;

@SuppressWarnings("serial")
public class PairsOfProducts implements PairFlatMapFunction<Iterable<String>, String, Integer> {

	public Iterable<Tuple2<String, Integer>> call(Iterable<String> products) {
		List<Tuple2<String, Integer>> results = new ArrayList<>();

		for (String p1 : products) {
			for (String p2 : products) {
				if (p1.compareTo(p2) > 0)
					results.add(new Tuple2<>(p1 + " " + p2, 1));
			}
		}

		return results;
	}

}
