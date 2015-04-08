package com.gc;

public class Replacer {
	
	public static Holder replaceTargetsWithTranslations(Holder ourHolder) {
		String[] targets = ourHolder.getTargets();
		String[] translations = ourHolder.getTranslations();
		String body = ourHolder.getBody();
		
		for (int i = 0; i < translations.length; i++) {
			translations[i] = "<a href=\"#\" class=\"tip\" title=\"" + targets[i] + "\">" + translations[i] + "</a>";
		}
		
		for (int i = 0; i < translations.length; i++) {
			body = body.replace(targets[i], translations[i]);
		}
		
		ourHolder.setBody(body);
		
		return ourHolder;
	}

}