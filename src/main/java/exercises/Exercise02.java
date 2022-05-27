/*
 * MainClass.java
 * Copyright (C) 2020 Stephan Seitz <stephan.seitz@fau.de>
 *
 * Distributed under terms of the GPLv3 license.
 */
package exercises;

import mt.LinearFilter;
import mt.Signal;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Exercise02 {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {

		var connection = new URL(url).openConnection();
		connection.setRequestProperty("Accept", "application/json");
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
		String jsonText = readAll(rd);
		JSONObject json = new JSONObject(jsonText);
		return json;
	}


	// Erik Goesche ge76imih
	public static void main(String[] args) throws MalformedURLException, IOException {
		var response = readJsonFromUrl("https://api.corona-zahlen.org/germany/history/cases");
		var data = response.getJSONArray("data");

		var cases = new float[data.length()];
		for (int i = 0; i < data.length(); i++) {
			cases[i] = data.getJSONObject(i).getFloat("cases");
		}

		System.out.println(
				"Data provided by Robert-Koch-Institut via " + response.getJSONObject("meta").getString("info"));
		System.out.println("Data from " + data.getJSONObject(0).getString("date") + " to "
				+ data.getJSONObject(data.length() - 1).getString("date"));

		// TODO: Initialize an object from the class signal and play around with it by applying some filters to it
		Signal caseSignal = new Signal(cases, "Cases for each day");
		caseSignal.show();
		float[] kernel = {1.0f/7.0f, 1.0f/7.0f, 1.0f/7.0f, 1.0f/7.0f, 1.0f/7.0f, 1.0f/7.0f, 1.0f/7.0f};
		LinearFilter filter = new LinearFilter(kernel, "Filter");
		Signal flattenCaseSignal = filter.apply(caseSignal);
		flattenCaseSignal.show();
	}
}
