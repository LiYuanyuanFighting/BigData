1)17/04/14 17:59:30 INFO mapreduce.Job: Task Id : attempt_1490278754144_2728_m_000018_1, Status : FAILED
Error: java.io.IOException: Initialization of all the collectors failed. Error in last collector was :null  

I checked online, some people said:  
 have got the same error when output types from map task didn't matched with input types of reduce task.  
 Then I checked my code, for reducer1, the output key is Text, value is IntWritable; for mapper2, the output  
 key is Text, value is also Text, because I chose KeyValueTextInputFormat for the 2nd mapper. So there must be  
 some error here, go on thinking...   
 
 
This explanation seemed better:
The problem is that the class that you're using for map() output / reduce() input, Weather does not implement Writable. This will prevent the default SerializationFactory from being able to process your values.

The underlying conceptual problem is that Hadoop does not know how to serialize your data type to disc and read it back. That is a mandatory step, because the data has to be persisted before it can be moved from the map task to a reducer (the two can run on separate nodes, in general).

So what you want to do is implement Writable and add serialization routines in your custom data type.
 
In the self defined classes: TopKVector doesn't implement Writable, so hadoop does not know how to serialize the data, but  
class WordCountWritable implements Writable.
