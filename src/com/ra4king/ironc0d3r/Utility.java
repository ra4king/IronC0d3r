package com.ra4king.ironc0d3r;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Roi Atalla
 */
public class Utility {
	public static String readAll(InputStream in) throws Exception {
		StringBuilder sb = new StringBuilder();

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
			String line;
			while((line = reader.readLine()) != null)
				sb.append(line).

				                 append('\n');
		}

		return sb.toString();
	}

	public static ArrayList<String> readLines(InputStream in) throws Exception {
		ArrayList<String> lines = new ArrayList<>();

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
			String line;
			while((line = reader.readLine()) != null)
				lines.add(line);
		}

		return lines;
	}
}
