package com.gc;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;

import com.neovisionaries.i18n.LanguageCode;

public class OurTranslator {

	public static Holder translateSentences(Holder ourHolder) {

		String language = getLanguageCode(ourHolder);
		String[] randomTargetedSentencesArray = ourHolder.getTargets();
		String[] translations = new String[randomTargetedSentencesArray.length];

		for (int i = 0; i < randomTargetedSentencesArray.length; i++) {
			translations[i] = GoogleTranslate.googleTranslateApi(randomTargetedSentencesArray[i], "en", language);

		}

		ourHolder = new Holder(ourHolder, randomTargetedSentencesArray,
				translations);

		return ourHolder;
	}

	public static String getLanguageCode(Holder ourHolder) {
		String languageCode = ourHolder.getLanguage();
		languageCode = WordUtils.capitalize(languageCode);
		List<LanguageCode> code = LanguageCode.findByName(languageCode);
		languageCode = code.get(0).toString();

		return languageCode;
	}
}
