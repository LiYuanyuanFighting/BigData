package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.*;
import org.apache.spark.api.java.function.Function;

import scala.Tuple2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;

public class SparkDriver {

	public static void main(String[] args) {

		String inputPath;
		String inputPath2;
		Double threshold;
		String outputNameFileKML;

		inputPath = args[0];
		inputPath2 = args[1];
		threshold = new Double(args[2]);
		outputNameFileKML = args[3];

		// Create a configuration object and set the name of the application
		SparkConf conf = new SparkConf().setAppName("Spark Lab #7");

		// Create a Spark Context object
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Read the content of the input file
		JavaRDD<String> inputRDD = sc.textFile(inputPath);

		// TODO
		// filter the lines with used slots=0 and free slots=0
		JavaRDD<String> readingsRDD = inputRDD.filter(new preProcessing());
		System.out.println("readingsRDD:" + readingsRDD.count());
		// Map each line of the input file to a pair stationid, timestamp
		JavaPairRDD<String, Count> stationPairRDD = readingsRDD.mapToPair(new StationTimePair());
		System.out.println("stationPairRDD:" + stationPairRDD.count());
		// Compute the number of total and critical readings for each station
		JavaPairRDD<String, Count> stationTotalPairRDD = stationPairRDD.reduceByKey(new Sum());
		System.out.println("stationTotalPairRDD:" + stationTotalPairRDD.count());
		// Compute criticality
		JavaPairRDD<String, Double> stationPercent = stationTotalPairRDD.mapValues(new Percentage()); 
		System.out.println("stationPercent:" + stationPercent.count());
		// Select stationTime with percentage > threshold
		JavaPairRDD<String, Double> selectedStationPercent = stationPercent.filter(new CriticalPercent(threshold));
		System.out.println("selectedStationPercent:" + selectedStationPercent.count());
		// Selects the most critical timeslot for each station
		// 1st change the key and value
		JavaPairRDD<String, timeDateCri> changedPair= selectedStationPercent.mapToPair(new changePair());
		System.out.println("changedPair:" + changedPair.count());
		// 2nd get most critical one
		JavaPairRDD<String, timeDateCri> criticality = changedPair.reduceByKey(new Max());
		System.out.println("criticality:" + criticality.count());
		/*// 2nd group by key
		JavaPairRDD<String, Iterable<Tuple2<String, Double>>> keyPair = changedPair.groupByKey();
		// 3rd get most critical one
		while (keyPair.keys().toLocalIterator().hasNext()) {
			String key = keyPair.keys().toLocalIterator().next();
			Iterable<Tuple2<String, Double>> tuple2 = keyPair.lookup(key).iterator().next();
			// TO DO
		}
		JavaPairRDD<String, Tuple2<String, Double>> mostCriticalSta = keyPair.takeOrdered(1, new CriticalComparator());
		*/
		// deal with 2nd file to get latitude and longitude
		JavaRDD<String> inputRDD2 = sc.textFile(inputPath2);
		JavaPairRDD<String, String> StaLocation = inputRDD2.mapToPair(new StaLocationPair());
		// join 2 pairs
		JavaPairRDD<String, Tuple2<timeDateCri, String>> StaLocaCri = criticality.join(StaLocation);
		
		// Store in resultKML one String, representing a KML marker, for each station 
		// with a critical timeslot 
		// JavaRDD<String> resultKML = ;
		JavaRDD<String> resultKML = StaLocaCri.map(new ToKML());
		
		// There is at most one string for each station. We can use collect and
		// store the returned list in the main memory of the driver.
		List<String> localKML = resultKML.collect();
		
		// Store the result in one single file stored in the distributed file
		// system
		// Add header and footer, and the content of localKML in the middle
		Configuration confHadoop = new Configuration();

		try {
			URI uri = URI.create(outputNameFileKML);

			FileSystem file = FileSystem.get(uri, confHadoop);
			FSDataOutputStream outputFile = file.create(new Path(uri));

			BufferedWriter bOutFile = new BufferedWriter(new OutputStreamWriter(outputFile, "UTF-8"));

			// Header
			bOutFile.write("<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document>");
			bOutFile.newLine();

			// Markers
			for (String lineKML : localKML) {
				bOutFile.write(lineKML);
				bOutFile.newLine();
			}

			// Footer
			bOutFile.write("</Document></kml>");
			bOutFile.newLine();

			bOutFile.close();
			outputFile.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Close the Spark context
		sc.close();
	}

}
