package com.ra4king.ironc0d3r.problem3;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
 * This problem required us to find the centroid of all the pairs of points given. The centroid is simply point containing
 * the average of the X coordinates and the average of the Y coordinates.
 * <p>
 * (0,0),(0,2) -> (0,1)
 * (1,1),(4,5),(7,6) -> (4,3)
 *
 * @author Roi Atalla
 */
public class Problem3 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem3.class.getResourceAsStream("Question3_input.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question3_output.txt"))) {
			for(String s : lines) {
				String output = findCentroid(s);

				if(output != null) {
					writer.println(output);
				}
			}
		}
	}

	/**
	 * Split by commas, trim parenthesis, every 2 is a pair, add and divide, simple stuff.
	 *
	 * @param input String containing coordinates.
	 * @return String containing centroid pair.
	 */
	private static String findCentroid(String input) {
		String[] parts = input.split(",");
		if(parts.length > 0) {

			if(parts.length % 2 != 0) {
				System.out.println("ERRORRRR");
			}

			int x = 0, y = 0;

			for(int a = 0; a < parts.length; a += 2) {
				x += clean(parts[a]);
				y += clean(parts[a + 1]);
			}

			// Rounded to the nearest tenth
			String formattedX = String.format("%.1f", (double)x / (parts.length / 2));
			String formattedY = String.format("%.1f", (double)y / (parts.length / 2));

			// The requirement wanted numbers ending with ".0" to leave it out
			if(formattedX.endsWith(".0")) {
				formattedX = formattedX.substring(0, formattedX.indexOf('.'));
			}
			if(formattedY.endsWith(".0")) {
				formattedY = formattedY.substring(0, formattedY.indexOf('.'));
			}

			return "(" + formattedX + "," + formattedY + ")";
		}

		return null;
	}

	/**
	 * Trim whitespaces and non-characters.
	 *
	 * @param input String to trim.
	 * @return Trimmed String.
	 */
	private static int clean(String input) {
		input = input.trim();

		StringBuilder builder = new StringBuilder();
		for(int a = 0; a < input.length(); a++) {
			char c = input.charAt(a);
			if(c >= '0' && c <= '9') {
				builder.append(c);
			}
		}

		return Integer.parseInt(builder.toString());
	}
}
