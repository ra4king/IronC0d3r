package com.ra4king.ironc0d3r.problem6;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ra4king.ironc0d3r.Utility;

/**
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
