package com.ra4king.ironc0d3r.problem6;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
 * This problem required us to find the closest power-of-two value to the given input integer, picking the higher value
 * in case of equal distances.
 *
 * @author Roi Atalla
 */
public class Problem6 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem6.class.getResourceAsStream("Question6_input.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question6_output.txt"))) {
			for(String s : lines) {
				int i = s.contains(".") ? (int)Math.floor(Float.parseFloat(s)) : Integer.parseInt(s);

				writer.println(closestPOW(i));
			}
		}
	}

	/**
	 * Simple algorithm of taking the highest 1 bit of the input integer and testing against it and the bit shifted to the left.
	 * 
	 * @param i The input integer to test.
	 * @return The closest power-of-two integer, with the higher value given in case of equal distances.
	 */
	private static int closestPOW(int i) {
		int a = Integer.highestOneBit(i);

		if(a == i) {
			return a;
		}

		int next = a << 1;

		if(Math.abs(a - i) >= Math.abs(next - i)) {
			return next;
		} else {
			return a;
		}
	}
}
