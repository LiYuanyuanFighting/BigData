When I run lab2 with parameter passed through command line, I always had NullPointerException, after  
asking professor, got the reason:  
In configuration, I first wrote:  
'Job job = Job.getInstance(conf)'   
then   
conf.set("BeginWord", args[2]); // To set parameter  
Obviously, it is too late to set parameter at that time, because the job has already used  
the old conf...  

I always have the problem with connecting to the gateway through FileZilla:  
host: sftp://localhost
Username: root  Password: root Port:2122  
So have to use the command:
scp -P 2122 document.txt root@localhost  
Then transfered the file document.txt to docker

**questions from lab2**  
What is the size of your input dataset, compared to the simple word counts (1­grams)? Did 
you need the cluster to filter the 1­grams? What about the 2­grams (or the n­grams for the n 
of your choice)?
--A cluster is a group of servers and other resources that act like a single system and enable  
high availability and, in some cases, load balancing and parallel processing. (A Hadoop cluster  
is a special type of computational cluster designed specifically for storing and analyzing huge  
amounts of unstructured data in a distributed computing environment.)  
So for small amount data to process, there is no need to use the cluster
--

To match the first several characters can use:

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MatcherExample {

    public static void main(String[] args) {

        String text    =
            "This is the text to be searched " +
            "for occurrences of the http:// pattern.";

        String patternString = ".*http://.*";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
    }
}

First a Pattern instance is created from a regular expression, and from the Pattern instance    
a Matcher instance is created. Then the matches() method is called on the Matcher instance.   
The matches() returns true if the regular expression matches the text, and false if not. 
