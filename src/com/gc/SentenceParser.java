package com.gc;

import java.util.ArrayList;
import java.util.Random;

public class SentenceParser {
	
	public static Holder parseParagraphsIntoSentences(Holder ourHolder) {
		Random rand = new Random();
		String[] paragraphs = ourHolder.getTargets();
		ArrayList<String> listOfTargets = new ArrayList<String>();
		
		for (int i = 0; i < paragraphs.length; i++) {
			String[] tempArray = paragraphs[i].split("(?<=[.?!])\\s+(?=[A-Z])");
			int max = tempArray.length;
			int randomNum = rand.nextInt(max);
			listOfTargets.add(tempArray[randomNum]);
		}
		
		String[] arrayOfTargets = new String[listOfTargets.size()];
		for (int i = 0; i < arrayOfTargets.length; i++) {
			arrayOfTargets[i] = listOfTargets.get(i);
		}
		
		ourHolder = new Holder(ourHolder, arrayOfTargets);
		
		return ourHolder;
	}
}