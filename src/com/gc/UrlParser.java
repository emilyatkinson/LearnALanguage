package com.gc;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class UrlParser {
	
	public static Document getPageHtml(String userUrl) throws IOException {
		
		Document html = Jsoup.connect(userUrl).get();
		
		return html;
	}
}
