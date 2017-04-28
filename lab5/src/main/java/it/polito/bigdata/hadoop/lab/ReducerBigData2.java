package it.polito.bigdata.hadoop.lab;

import java.io.IOException;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Lab - Reducer #2
 */

/* Set the proper data types for the (key,value) pairs */
class ReducerBigData2 extends Reducer<
                Text,           // Input key type
                FloatWritable,    // Input value type
                Text,           // Output key type
                FloatWritable> {  // Output value type
    
    @Override
    protected void reduce(
        Text key, // Input key type
        Iterable<FloatWritable> values, // Input value type
        Context context) throws IOException, InterruptedException {

		/* Implement the reduce method */
    	float sum = 0;
    	float avg = 0;
    	int size = 0;
    	for (FloatWritable value : values) {
    		sum += value.get();
    		size++;
    	}
    	avg = sum/size;
    	
    	context.write(key, new FloatWritable(avg));
    }
}
