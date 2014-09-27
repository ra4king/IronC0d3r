package com.ra4king.ironc0d3r.problem5;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
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

	private static int hexFCount(String hex) {
		int count = 0;
		for(int a = 0; a < hex.length(); a++) {
			if(hex.charAt(a) == 'F') {
				count++;
			}
		}

		return count;
	}

	public static String intToHex(int hex) {
		String s = "";

		char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		int num = hex;
		do {
			s = hexChars[num % 16] + s;
			num >>>= 4;
		} while(num > 0);

		return s;
	}
}
