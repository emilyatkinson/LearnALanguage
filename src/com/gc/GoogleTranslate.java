package com.gc;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class GoogleTranslate {
 
    private String key;
 
    public GoogleTranslate(String apiKey) {
        key = apiKey;
    }
 
    String translte(String text, String originalLanguage, String translationLanguage) {
        StringBuilder result = new StringBuilder();
        try {
            String encodedText = URLEncoder.encode(text, "UTF-8");
            String urlStr = "https://www.googleapis.com/language/translate/v2?key=" + key + "&q=" + encodedText + "&target=" + translationLanguage + "&source=" + originalLanguage;
 
            URL url = new URL(urlStr);
 
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            InputStream stream;
            if (conn.getResponseCode() == 200) //success
            {
                stream = conn.getInputStream();
            } else
                stream = conn.getErrorStream();
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
 
            JsonParser parser = new JsonParser();
 
            JsonElement element = parser.parse(result.toString());
 
            if (element.isJsonObject()) {
                JsonObject obj = element.getAsJsonObject();
                if (obj.get("error") == null) {
                    String translatedText = obj.get("data").getAsJsonObject().
                    get("translations").getAsJsonArray().
                    get(0).getAsJsonObject().
                    get("translatedText").getAsString();
                    return translatedText;
 
                }
            }
 
            if (conn.getResponseCode() != 200) {
                System.err.println(result);
            }
 
        } catch (IOException | JsonSyntaxException ex) {
            System.err.println(ex.getMessage());
        }
 
        return null;
    }
    public static String googleTranslateApi(String target, String originalLanguage, String translationLanguage) {
 
        GoogleTranslate translator = new GoogleTranslate("AIzaSyBP23_YSrUG9CxR-MdiBdV71E9tgpO02Zo");
        String translation = translator.translte(target, originalLanguage, translationLanguage);
        return translation;
    }
}