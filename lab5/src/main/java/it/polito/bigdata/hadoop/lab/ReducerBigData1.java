package it.polito.bigdata.hadoop.lab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Lab - Reducer #1
 */

/* Set the proper data types for the (key,value) pairs */
class ReducerBigData1 extends Reducer<
                Text,           // Input key type
                ProductWritable,    // Input value type
                Text,           // Output key type
                FloatWritable> {  // Output value type
    
    @Override
    protected void reduce(
        Text key, // Input key type
        Iterable<ProductWritable> values, // Input value type
        Context context) throws IOException, InterruptedException {

		/* Implement the reduce method */
    	// UserWritable user = new UserWritable(key.toString(), products);
    	float average = 0;
	    float sum = 0;
	    int size = 0;
	    List<ProductWritable> newProducts = new ArrayList<ProductWritable>();
	    
    	for (ProductWritable p : values) {
    		// user.addScore(p);
    		sum += p.getScore();
    		size++;
    		newProducts.add(new ProductWritable(p));// should add new ProductWritable, otw always be replaced
    	}
    	
	    
	    average = sum / size;
	    System.out.println("Check " + average);

	    // still have this value or not?
	    for (ProductWritable p : newProducts) {
	    	// p.setScore(p.getScore() - average);
	    	System.out.println("Check id " + p.getId());
	    	String id = p.getId();
	    	float score = p.getScore() - average;
	    	context.write(new Text(id), new FloatWritable(score));
	    }
	    
    }
}
