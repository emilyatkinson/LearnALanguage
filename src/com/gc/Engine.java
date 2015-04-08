package com.gc;

public class Engine {
	
	public static final Engine OUR_ENGINE = new Engine();

	public Holder ourEngine(Holder ourHolder) {
		
		ourHolder = ParagraphParser.parseBodyIntoParagraphs(ourHolder);
		ourHolder = SentenceParser.parseParagraphsIntoSentences(ourHolder);
		ourHolder = OurTranslator.translateSentences(ourHolder);
		ourHolder = Replacer.replaceTargetsWithTranslations(ourHolder);
		
		return ourHolder; 
	}

}