package com.ra4king.ironc0d3r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Roi Atalla
 */
public class Utility {
	/**
	 * Reads each line into a List.
	 *
	 * @param in The Input Stream to read from.
	 * @return The list of lines
	 * @throws IOException
	 */
	public static ArrayList<String> readLines(InputStream in) throws IOException {
		ArrayList<String> lines = new ArrayList<>();

		try(BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
			String line;
			while((line = reader.readLine()) != null)
				lines.add(line);
		}

		return lines;
	}
}
