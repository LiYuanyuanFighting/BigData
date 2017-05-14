**Command used**    
spark-submit --class it.polito.bigdata.spark.example.SparkDriver --deploy-mode client --master yarn Exercise6Bonus.jar 
"/data/students/bigdata-01QYD/Lab3/Reviews.csv" ex62D0_out  

**Procedures**  
mapToPair -> groupByKey -> values -> flatMapToPair(First create pairs, then gather all pairs together in one list) -> reduceByKey  
-> filter -> (To swap value and key then be able to sort by frequency)mapToPair -> sortByKey

**takeOrdered and top**  
Note that Spark 1.6, or above, provides the following actions that can be applied on an RDD
of type JavaRDD<T>:
1) List<T> top(int n, java.util.Comparator<T> comp)
2) List<T> takeOrdered (int n, java.util.Comparator<T> comp)
top returns the n largest elements of the RDD based on the specified Comparator
takeOrdered returns the n smallest elements of the RDD based on the specified(use -1 in its comparator)
Comparator  
And don't forget to implement Serializable in the comparator, otherwise will have error stating not serializable  
And use compareTo()! 
