package com.gc;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParagraphParser {

	public static Holder parseBodyIntoParagraphs(Holder ourHolder) {
		String body = ourHolder.getBody();

		Document doc = Jsoup.parse(body);
		Elements paragraphElements = doc.select("p");

		String[] paragraphs = new String[paragraphElements.size()];

		for (int i = 0; i < paragraphs.length; i++) {
			paragraphs[i] = paragraphElements.get(i).text();
		}

		ourHolder = new Holder(ourHolder, paragraphs);

		return ourHolder;
	}

}