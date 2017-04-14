1)17/04/14 17:59:30 INFO mapreduce.Job: Task Id : attempt_1490278754144_2728_m_000018_1, Status : FAILED
Error: java.io.IOException: Initialization of all the collectors failed. Error in last collector was :null  

I checked online, some people said:  
 have got the same error when output types from map task didn't matched with input types of reduce task.  
 Then I checked my code, for reducer1, the output key is Text, value is IntWritable; for mapper2, the output  
 key is Text, value is also Text, because I chose KeyValueTextInputFormat for the 2nd mapper. So there must be  
 some error here, go on thinking...
 
