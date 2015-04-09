package com.gc;

public class Engine {
	
	public static final Engine OUR_ENGINE = new Engine();

	public Holder ourEngine(Holder ourHolder) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		ourHolder = ParagraphParser.parseBodyIntoParagraphs(ourHolder);
//		ourHolder = SentenceParser.parseParagraphsIntoSentences(ourHolder);
		ourHolder = WordParser.parseParagraphsIntoWords(ourHolder);
		ourHolder = OurTranslator.translateSentences(ourHolder);
		ourHolder = Replacer.replaceTargetsWithTranslations(ourHolder);
		
		return ourHolder; 
	}

}