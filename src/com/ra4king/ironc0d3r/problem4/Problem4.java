package com.ra4king.ironc0d3r.problem4;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
 * @author Roi Atalla
 */
public class Problem4 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem4.class.getResourceAsStream("Question4_input.txt"));
		ArrayList<String> dictionary = Utility.readLines(Problem4.class.getResourceAsStream("dictionary.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question4_output.txt"))) {
			for(String s : lines) {
				writer.println(longestSubstring(s, dictionary));
			}
		}
	}

	private static String longestSubstring(String input, ArrayList<String> dictionary) {
		input = input.toLowerCase();

		String longestSubstring = "";
		for(String s : dictionary) {
			if(input.contains(s.toLowerCase()) && s.length() >= longestSubstring.length()) {
				if(!(s.length() == longestSubstring.length() && longestSubstring.compareToIgnoreCase(s) < 0)) {
					longestSubstring = s;
				}
			}
		}

		return longestSubstring;
	}
}
