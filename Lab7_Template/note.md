spark-submit --class it.polito.bigdata.spark.example.SparkDriver --deploy-mode client --master yarn Exercise73.jar "/data/students/bigdata-01QYD/Lab7/register.csv" "/data/students/bigdata-01QYD/Lab7/stations.csv" 0.5 "criticalStations.kml"

A mistake took me over 3 hours to figure out:
The key is combined by id+weekday+hour
but I used id+date(year+month+weekday)+hout
Then found in the output:
readingsRDD:25104121                                                            
stationPairRDD:25104121                                                         
stationTotalPairRDD:856799                                                      
stationPercent:856799                                                           
selectedStationPercent:25499
changedPair:25499
criticality:265
Correct one should be:
readingsRDD:25104121                                                            
stationPairRDD:25104121                                                         
stationTotalPairRDD:47550                                                       
stationPercent:47550                                                            
selectedStationPercent:33                                                       
changedPair:33                                                                  
criticality:16
