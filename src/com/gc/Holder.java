package com.gc;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Holder implements Serializable {
	private String body;
	private String language;
	private String[] targets;
	private String[] translations;
	
	public Holder() { }
	
	public Holder(Holder init, String[] targets) {
		this.body = init.body;
		this.language = init.language;
		this.targets = targets;
	}
	
	public Holder(Holder init, String[] targets, String[] translations) {
		this.body = init.body;
		this.language = init.language;
		this.targets = targets;
		this.translations = translations;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String[] getRandomTargetedSentences() {
		return targets;
	}

	public void setTargets(String[] targets) {
		this.targets = targets;
	}

	public String[] getTranslations() {
		return translations;
	}

	public void setTranslations(String[] replacements) {
		this.translations = replacements;
	}


}