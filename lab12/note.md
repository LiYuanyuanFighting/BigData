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
