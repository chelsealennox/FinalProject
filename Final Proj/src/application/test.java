package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class test {

	/**
	 * This is the main method where the program starts
	 * @param args for main
	 * @throws IOException when the log file could not be created
	 */

	public static void main(String[] args) throws IOException {
		
		/**
		 * this method reads the gutenburg file
		 */
	URL gutenburg = null;
	try {
	gutenburg = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm?courseID=164189&assignmentID=4456667&skipModuleItemSequence=true");
	} catch (MalformedURLException e) {
			
		e.printStackTrace();
		}
	
	BufferedReader br = new BufferedReader(new InputStreamReader(gutenburg.openStream()));
			 
		/**
		 * This line creates a hashmap for wordCounts
		 */
		
		Map<String, Integer> wordCounts = new HashMap<>();
		
		/**
		 * inputLine variable is to store input lines
		 */
		String inputLine; 

		while ((inputLine = br.readLine()) != null) {

		String[] words = inputLine.split("[\\s.;,?:!()\"]+");

		/**
		 * This method iterates the words
		 */
		for (String word : words) {

			word = word.trim();

			if (word.length() > 0) {

			if (wordCounts.containsKey(word)) {
				wordCounts.put(word, wordCounts.get(word) + 1);
				} else {
			wordCounts.put(word, 1);
			}
		}
	}
	}
		/**
	 	* This method sorts wordCounts by it's frequency using Map
	 	*/
		
	Map<String, Integer> sortedWordCounts = wordCounts.entrySet().stream().sorted(Collections.reverseOrder(Entry.comparingByValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	/**
	*Prints each words and its frequency number
	*/
		
	System.out.printf("%-20s%15s\n", "Word", "Frequency");

	System.out.printf("%-20s%15s\n", "====", "=========");

	for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {

	System.out.printf("%-20s%10s\n", entry.getKey(), entry.getValue());
			}

			br.close();
	} 
}//End of test Class
