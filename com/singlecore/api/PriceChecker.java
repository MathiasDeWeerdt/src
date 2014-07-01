package com.singlecore.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum PriceChecker {
	
	LOGS("818-logs"), 
	OAK_LOGS("823-oak-logs"), 
	WILLOW_LOGS("822-willow-logs"), 
	MAPLE_LOGS("821-maple-logs"), 
	YEW_LOGS("820-yew-logs"), 
	MAGIC_LOGS("819-magic-logs");
	
	private final String URL_BASE = "http://forums.zybez.net/runescape-2007-prices/";
	private final String URL_END;
	
	PriceChecker(String URL_END) {
		this.URL_END = URL_END;
	}
	
	public int getPrice() throws Exception {
		Pattern p = Pattern.compile("~\\d{1,5}.\\d{1,5} GP|~\\d{2}");
		Matcher m = p.matcher(getText(URL_BASE + URL_END));

		while (m.find()) {
			return Integer.parseInt(m.group().replace("~", "").replace(",", "").replace(" ", "").replace("GP", ""));
		}
		
		return 0;
	}

	public String getText(String url) throws Exception {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		connection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);

		in.close();
		return response.toString();
	}
	
}