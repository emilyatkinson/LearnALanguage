package com.gc;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.gtranslate.Language;
import com.neovisionaries.i18n.LanguageCode;

public class OurTranslator {

	public static Holder translateSentences(Holder ourHolder) {

		String language = ourHolder.getLanguage();
		language = WordUtils.capitalize(language);
		String[] randomTargetedSentencesArray = ourHolder.getRandomTargetedSentences();
		String[] translations = new String[randomTargetedSentencesArray.length];
		List<LanguageCode> code = LanguageCode.findByName(language);
		language = code.get(0).toString();

		for (int i = 0; i < randomTargetedSentencesArray.length; i++) {
			translations[i] = GoogleTranslate.googleTranslateApi(randomTargetedSentencesArray[i],
					Language.ENGLISH, language);
//					+ "THIS IS WHERE THE COMMENT BELOW GOES, DON'T PUT IT IN HERE UNLESS YOU WANT TO MAKE ME OVERDRAFT, I'M BROKE!!";
		}

		ourHolder = new Holder(ourHolder, randomTargetedSentencesArray, translations);

		return ourHolder;
	}
}

//GoogleTranslate.googleTranslateApi(targets[i],
//		Language.ENGLISH, language)