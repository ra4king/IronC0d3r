package com.ra4king.ironc0d3r.problem5;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
 * This problem simply wanted us to print the number of 'F' characters in the hex String of each input integer.
 *
 * @author Roi Atalla
 */
public class Problem5 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem5.class.getResourceAsStream("Question5_input.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question5_output.txt"))) {
			for(String s : lines) {
				String hex = intToHex(Integer.parseInt(s));
				writer.println(hexFCount(hex));
			}
		}
	}

	/**
	 * Counts the number of 'F' characters in the given hex String.
	 *
	 * @param hex The hex String to search through.
	 * @return The count of 'F' characters.
	 */
	private static int hexFCount(String hex) {
		int count = 0;
		for(int a = 0; a < hex.length(); a++) {
			if(hex.charAt(a) == 'F') {
				count++;
			}
		}

		return count;
	}

	/**
	 * This function converts the integer into its hex String
	 *
	 * @param num The integer to convert.
	 * @return The hex String.
	 */
	public static String intToHex(int num) {
		String s = "";

		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		do {
			s = hexChars[num & 0xF] + s;
			num >>>= 4;
		} while(num > 0);

		return s;
	}
}
