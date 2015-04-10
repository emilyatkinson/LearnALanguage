package com.gc;

public class Replacer {

	public static Holder replaceTargetsWithTranslations(
			Holder ourHolder) throws IllegalArgumentException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		String[] englishText = ourHolder.getTargets();
		String[] translations = ourHolder.getTranslations();
		String body = new String(ourHolder.getBody());

		java.lang.reflect.Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		char[] chars = (char[]) field.get(body);

		for (int i = 0, n = chars.length; i < n; i++) {
			String translationWithHoverOver = null;
			if (i < translations.length) {
				String highlightedTranslatedText = "<mark>" + translations[i] + "</mark>";
				translationWithHoverOver = "<class=\"tip\" title=\"" + englishText[i] + "\">" + highlightedTranslatedText + "</class>";
				body = body.replace(englishText[i], translationWithHoverOver);

			}

			ourHolder.setBody(body);

		}
		return ourHolder;

	}
}