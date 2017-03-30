package it.polito.bigdata.hadoop.lab;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Lab  - Mapper
 */

/* Set the proper data types for the (key,value) pairs */
class MapperBigData extends Mapper<
                    Text, // Input key type
                    IntWritable,         // Input value type
                    Text,           // Output key type
                    IntWritable> {// Output value type
    
    protected void map(
            Text key,   // Input key type
            IntWritable value,         // Input value type
            Context context) throws IOException, InterruptedException {

    		/* Implement the map method */ 
    		if (key.toString().substring(0, 1).equals("ho")) {
    			context.write(key, value);
    		}
    }
}
