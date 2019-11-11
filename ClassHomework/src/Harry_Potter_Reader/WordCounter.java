package Harry_Potter_Reader;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounter {
	static HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		try {
			
			File script = new File("harry_potter.txt");
			Scanner s = new Scanner(script);
			System.out.println("file is open");
			
			while(s.hasNext()) {
				String newWord = s.next();
				newWord = stripCharacters(newWord);
				addToCount(newWord);
			}
			printWords();
			s.close();
			
			
		} catch (Exception e) {
			System.out.println("error opening the file");
		}
		
		
	}
	
	public static void addToCount(String word) {
		if(wordCount.containsKey(word)) {
			wordCount.replace(word, wordCount.get(word)+1);
		} else {
			wordCount.put(word, 1);
		}
	}
	
	public static String stripCharacters(String s) {
		s = s.trim();
		s = s.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		return s;
	}

	public static void printWords() {
		for(String s : wordCount.keySet()) {
			System.out.println(s + " : " + wordCount.get(s));
		}
	}
}
