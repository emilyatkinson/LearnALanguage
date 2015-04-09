package com.gc;

public class Engine {

	public static final Engine OUR_ENGINE = new Engine();

	public Holder ourEngine(Holder ourHolder, String[] languageLevel)
			throws IllegalArgumentException, IllegalAccessException,
			NoSuchFieldException, SecurityException {

		ourHolder = ParagraphParser.parseBodyIntoParagraphs(ourHolder);

		if (languageLevel[0].equalsIgnoreCase("beginner")) {
			ourHolder = WordParser.parseParagraphsIntoWords(ourHolder);
		}
		if (languageLevel[0].equalsIgnoreCase("intermediate")) {
			ourHolder = SentenceParser.parseParagraphsIntoSentences(ourHolder);
		}
		
		ourHolder = OurTranslator.translateSentences(ourHolder);
		ourHolder = Replacer
				.replaceRandomTargetedSentencesWithTranslations(ourHolder);

		return ourHolder;
	}

}