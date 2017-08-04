import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WordCount {
    public static void main(String[] args) {
    	
    	String s ="Wikipedia was launched on January 15, 2001, by Jimmy Wales and Larry Sanger. Sanger coined its name,"
    			+ " a portmanteau of wiki and encyclopedia. There was only the English-language version initially, "
    			+ "but it quickly developed similar versions in other languages, which differ in content and in editing practices. "
    			+ "With 5,453,620 articles, the English Wikipedia is the largest of the more than 290 Wikipedia encyclopedias. "
    			+ "Overall, Wikipedia consists of more than 40 million articles in more than 250 different languages and, "
    			+ "as of February 2014, it had 18 billion page views and nearly 500 million unique visitors each month." 
    			+ "As of March 2017, Wikipedia has about forty thousand high-quality articles known as Featured Articles "
    			+ "and Good Articles that cover vital topics. In 2005, Nature published a peer review comparing 42 "
    			+ "science articles from Encyclopædia Britannica and Wikipedia, and found that Wikipedia's level of "
    			+ "accuracy approached that of Encyclopædia Britannica. "
    			+ "Wikipedia has been criticized for allegedly exhibiting systemic bias, presenting a mixture of "
    			+ "truths, half truths, and some falsehoods\", and, in controversial topics, "
    			+ "being subject to manipulation and spin.";
    	System.out.println(count(s));
    }
    
    static List<String> count(String s1) {
      int numOfWords = 20;
    	ArrayList<String> answer = new ArrayList<String>();
    	HashMap<String, Integer> counter = new HashMap<String, Integer>();
    	HashMap<Integer, ArrayList<String>> values = new HashMap<Integer, ArrayList<String>>();
    	String t1 = s1.replace(",", "");
    	String s = t1.replace(".", "");
    	for( String w : s.split(" ")) {
    		if(counter.containsKey(w)) {
    			int count = counter.get(w);
    			counter.remove(w);
    			ArrayList<String> temp = new ArrayList<String>();
				temp = values.get(count);
				temp.remove(w);
				values.remove(count);
				values.put(count, temp);
    			ArrayList<String> temp1 = new ArrayList<String>();
    			if(values.containsKey(++count)) {
    				temp1 = values.get(count);
    				temp1.add(w);
    				counter.put(w, count);
    				values.remove(count);
    				values.put(count, temp1);
    			} else {
    				temp1.add(w);
    				counter.put(w, count);
    				values.put(count, temp1);
    			}
    		} else {
    			counter.put(w, 1);
    			ArrayList<String> temp = new ArrayList<String>();
    			if(values.get(1) != null) {
    				temp = values.get(1);
    				temp.add(w);
    				values.remove(1);
    				values.put(1, temp);
    			} else {
    				temp.add(w);
    				values.put(1, temp);
    			}
    		}
    	}
    	int length = 0;
    	while(length < numOfWords) {
    		int max = Collections.max(values.keySet());
    		ArrayList<String> words = new ArrayList<String>();
    		if( max > 0 ) {
    			words = values.get(max);
    			values.remove(max);
    			for(String w : words) {
    				if(length < numOfWords) {
    					answer.add(w + "" + max);
        				length++;
    				} else length = numOfWords;
    			}
    		}
    	}
    	return answer;
    }
}
