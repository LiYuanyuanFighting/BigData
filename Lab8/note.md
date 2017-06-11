use logistic regression

s231681@bigdatalab:~$ spark-submit --class it.polito.bigdata.spark.example.SparkDriver --deploy-mode client --master yarn Exercise8l.jar /data/students/bigdata-01QYD/Lab3/Reviews.csv 
+--------+-----+
|features|label|
+--------+-----+
| [263.0]|  1.0|
| [513.0]|  1.0|
| [219.0]|  1.0|
| [131.0]|  1.0|
| [781.0]|  1.0|
+--------+-----+
only showing top 5 rows

17/06/11 19:55:18 WARN netlib.BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeSystemBLAS
17/06/11 19:55:18 WARN netlib.BLAS: Failed to load implementation from: com.github.fommil.netlib.NativeRefBLAS
+--------+-----+--------------------+--------------------+----------+           
|features|label|       rawPrediction|         probability|prediction|
+--------+-----+--------------------+--------------------+----------+
|  [30.0]|  0.0|[-0.5527513697620...|[0.36522630607371...|       1.0|
|  [33.0]|  0.0|[-0.5526748230808...|[0.36524405253709...|       1.0|
|  [36.0]|  0.0|[-0.5525982763996...|[0.3652617993666,...|       1.0|
|  [36.0]|  1.0|[-0.5525982763996...|[0.3652617993666,...|       1.0|
|  [47.0]|  0.0|[-0.5523176052353...|[0.36532687420645...|       1.0|
+--------+-----+--------------------+--------------------+----------+
only showing top 5 rows

Confusion matrix:                                                               
0.0  33006.0  
0.0  56904.0  
Precision = 0.6328995662328996 


Use decision tree
s231681@bigdatalab:~$ spark-submit --class it.polito.bigdata.spark.example.SparkDriver --deploy-mode client --master yarn Exercise8l.jar /data/students/bigdata-01QYD/Lab3/Reviews.csv 
^Cs231681@bigdatalab:~$ spark-submit --class it.polito.bigdata.spark.example.SpaDriver --deploy-mode client --master yarn Exercise8l.jar /data/students/bigdata-01QYD/Lab3/Reviews.csv 
+--------+-----+
|features|label|
+--------+-----+
| [263.0]|  1.0|
| [513.0]|  1.0|
| [219.0]|  1.0|
| [131.0]|  1.0|
| [781.0]|  1.0|
+--------+-----+
only showing top 5 rows

+--------+-----+------------+---------------+--------------------+----------+--------------+
|features|label|indexedLabel|  rawPrediction|         probability|prediction|predictedLabel|
+--------+-----+------------+---------------+--------------------+----------+--------------+
|  [27.0]|  0.0|         1.0|[3155.0,2948.0]|[0.51695887268556...|       0.0|           1.0|
|  [35.0]|  0.0|         1.0|[3155.0,2948.0]|[0.51695887268556...|       0.0|           1.0|
|  [36.0]|  0.0|         1.0|[3155.0,2948.0]|[0.51695887268556...|       0.0|           1.0|
|  [45.0]|  0.0|         1.0|[3155.0,2948.0]|[0.51695887268556...|       0.0|           1.0|
|  [45.0]|  0.0|         1.0|[3155.0,2948.0]|[0.51695887268556...|       0.0|           1.0|
+--------+-----+------------+---------------+--------------------+----------+--------------+
only showing top 5 rows

Confusion matrix:                                                               
56716.0  0.0  
32946.0  0.0  
Precision = 0.632553367089737 
