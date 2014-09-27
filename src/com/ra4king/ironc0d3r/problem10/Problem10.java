package com.ra4king.ironc0d3r.problem10;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
 * @author Roi Atalla
 */
public class Problem10 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem10.class.getResourceAsStream("Question10_input.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question10_output.txt"))) {
			for(String s : lines) {
				writer.println(compress(s));
			}
		}
	}

	private static String compress(String s) {
		StringBuilder compressed = new StringBuilder();

		int count = 1;
		for(int a = 1; a < s.length(); a++) {
			if(s.charAt(a) != s.charAt(a - 1) || a == s.length() - 1) {
				if(s.charAt(a) == s.charAt(a - 1) && a == s.length() - 1) {
					count++;
				}

				if(count > 1) {
					compressed.append(count);
					count = 1;
				}

				compressed.append(s.charAt(a - 1));
			} else {
				count++;
			}
		}

		return compressed.toString();
	}
}
