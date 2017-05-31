On 05/30/2017 06:14 PM, Yuanyuan Li S231681 wrote:
Dear professor,
I have 2 questions about the course:

1. since everything used in machine learning library provided by

spark uses double data type, we should map categorical attributes

into doubles, but how to map while maintaining the characteristics of the

attributes. Also for clustering problems, we also need to do this not

because of spark.

e.g, there is dataset of adjectives, then i want to use k means to cluster

them, if I map the adjectives into random numbers, I think the result

will be not correct, how to map them into doubles correctly?


Answer: Unfortunately, everything is a double in MLLib. Hence, you must transform your data in a vector of double.

If you are using texts, usually every document text is  mapped to a vector containing one field for each word and a numerical value representing the importance of the word in the document. This is a standard transformation that is usually adopted also by the other machine learning libraries to work with text and categorical attributes.

Obviously, this approach is not appropriate if you want to compute the distance between two words based on their semantic. But this is a general problem of many of the general purpose classification and clustering algorithms when they are used to manage textual data.


2. I found all input data we used in the lab are in good format, we

can easily get information we want. But I think in reality, the collected

data may be in a disaster. Do they experience preprocessing like this:

http://www.cs.ccsu.edu/~markov/ccsu_courses/datamining-3.html

I wonder: there is such large amount of data, is there any tool to deal

with? e.g. how can we fill in all missing values?


Also MLlib provides some preprocessing functionalities:

https://spark.apache.org/docs/2.1.0/ml-features.html


Answer: However, some operations, like filling  missing values, is not provided by the basic library. You must write part of the code by yourself by writing a Spark based on the basic transformations and actions provide the the general purpose API of Spark.

Related links:  

https://stackoverflow.com/questions/399200/calculating-the-semantic-distance-between-words
https://en.wikipedia.org/wiki/Normalized_Google_distance
http://mkusner.github.io/publications/WMD.pdf
http://ants.iis.sinica.edu.tw/3BkMJ9lTeWXTSrrvNoKNFDxRm3zFwRR/55/Sentence%20Similarity%20Based%20on%20Semantic%20Nets%20and%20corpus%20statistics.pdf
http://www.betterevaluation.org/sites/default/files/data_cleaning.pdf
https://bdataanalytics.biomedcentral.com/articles/10.1186/s41044-016-0014-0
http://www.cortical.io/similarity-explorer.html


