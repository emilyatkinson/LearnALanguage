package com.gc;

import java.util.ArrayList;
import java.util.Random;

public class WordParser {

	public static Holder parseParagraphsIntoWords(Holder ourHolder) {
		Random rand = new Random();
		String[] paragraphs = ourHolder.getTargets();
		ArrayList<String> listOfWordTargets = new ArrayList<String>();

		for (int i = 0; i < paragraphs.length; i++) {

			String paragraphWithoutPunctuation = paragraphs[i].replaceAll(
					"[,.:;()]", ""); // need to work on this regex, especially
										// what to do with "
										// and ' such as in words like don't
										// can't it's
			String[] arrayOfWordsInParagraph = paragraphWithoutPunctuation
					.split("\\s+");

			int numberOfSentences = countWordsInParagraph(arrayOfWordsInParagraph);
			if (paragraphHasMoreThanThreeWords(numberOfSentences)) {

				int max = arrayOfWordsInParagraph.length;
				int randomNum = rand.nextInt(max);
				while (arrayOfWordsInParagraph[randomNum].length() < 4) {
					arrayOfWordsInParagraph[randomNum] = arrayOfWordsInParagraph[randomNum + 1];
				}
				listOfWordTargets.add(arrayOfWordsInParagraph[randomNum]);
			}
		
		}

		String[] arrayOfWordTargets = new String[listOfWordTargets.size()];
		for (int i = 0; i < arrayOfWordTargets.length; i++) {
			arrayOfWordTargets[i] = listOfWordTargets.get(i);
		}

		ourHolder = new Holder(ourHolder, arrayOfWordTargets);

		return ourHolder;
	}

	public static boolean paragraphHasMoreThanThreeWords(int numberOfWords) {
		return (numberOfWords > 2);
	}

	public static int countWordsInParagraph(String[] sentencesArray) {
		int numOfSentences = sentencesArray.length;
		return numOfSentences;
	}
}