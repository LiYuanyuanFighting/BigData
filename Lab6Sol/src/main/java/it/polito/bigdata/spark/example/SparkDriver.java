package it.polito.bigdata.spark.example;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;

public class SparkDriver {
	
	public static void main(String[] args) {

		String inputPath;
		String outputPath;

		inputPath=args[0];
		outputPath=args[1];

	
		// Create a configuration object and set the name of the application
		SparkConf conf=new SparkConf().setAppName("Spark Lab6");
		
		// Create a Spark Context object
		JavaSparkContext sc = new JavaSparkContext(conf);

		
		// Read the content of the input file
		JavaRDD<String> reviewsRDD = sc.textFile(inputPath);

		// Generate one pair UserId, ProductId for each input line
        JavaPairRDD<String,String> pairUserProduct = reviewsRDD.mapToPair(new PairUserIdProductID());
        
        // Generate one "transaction" for each user
        // <user_id> → < list of the product_ids reviewed>
        JavaPairRDD<String,Iterable<String>> UserIDListOfReviewedProducts = pairUserProduct.groupByKey();
        
        // We are interested only in the value part (the lists of products that have been reviewed together)
        
        JavaRDD<Iterable<String>> transactions = UserIDListOfReviewedProducts.values();

        // Generate a PairRDD of (key,value) pairs. One pair for each combination of products 
        // appearing in the same transaction  
        // - key = pair of products reviewed together
        // - value = 1  
        JavaPairRDD<String,Integer> pairsOfProductsOne = transactions.flatMapToPair(new PairsOfProducts());
        
        // Count the frequency (i.e., number of occurrencies) of each key (= pair of products)
        JavaPairRDD<String,Integer> pairsFrequencies = pairsOfProductsOne.reduceByKey(new CountFrequency());
		
        // Select only the pairs that appear more than once and their frequencies.
        JavaPairRDD<String,Integer> atLeast2PairsFrequencies = pairsFrequencies.filter(new AtLeast2());
        
        // Swap the role of key and value
        JavaPairRDD<Integer,String>  frequencyProducts = atLeast2PairsFrequencies.mapToPair(new swapRole());
        
        // Sort data by key 
        JavaPairRDD<Integer,String>  resultRDD=frequencyProducts.sortByKey(false);
        
        // Store the result
        resultRDD.saveAsTextFile(outputPath);
        
        // Close the Spark context
		sc.close();
	}
}
