package it.polito.bigdata.hadoop.lab;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Lab  - Mapper #1
 */

/* Set the proper data types for the (key,value) pairs */
class MapperBigData1 extends Mapper<
                    LongWritable, // Input key type
                    Text,         // Input value type
                    Text,         // Output key type
                    ProductWritable> {// Output value type
    
    protected void map(
            LongWritable key,   // Input key type
            Text value,         // Input value type
            Context context) throws IOException, InterruptedException {

    		/* Implement the map method */ 
    		String[] words = value.toString().split(",");
    		// to avoid the header
    		if (!words[6].equals("Score")) {
    			float score = Float.parseFloat(words[6]);
    			ProductWritable p = new ProductWritable(words[1].toString(), score);
    		
    			context.write(new Text(words[2]), new ProductWritable(p));
    			// should use new ProductWritable, otw will always be replaced
    		}
    }
}
