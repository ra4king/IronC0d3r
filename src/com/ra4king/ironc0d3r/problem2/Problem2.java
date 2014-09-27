package com.ra4king.ironc0d3r.problem2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import com.ra4king.ironc0d3r.Utility;

/**
 * @author Roi Atalla
 */
public class Problem2 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem2.class.getResourceAsStream("sample.txt"));//Question2_input.txt"));

		ArrayList<DNAPair> pairs = new ArrayList<>();
		for(String s : lines) {
			pairs.add(new DNAPair(s));
		}

		Collections.sort(pairs);

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question2_output.txt"))) {
			for(DNAPair pair : pairs) {
				writer.println(pair.dna);
				System.out.println(pair);
			}
		}
	}

	private static class DNAPair implements Comparable<DNAPair> {
		private String dna;
		private String largestChain = "";

		public DNAPair(String dna) {
			this.dna = dna;

			String currChain = "";
			ArrayList<String> chains = new ArrayList<>();
			for(int a = 0; a < dna.length(); a++) {
				if(a == 0 || dna.charAt(a) == dna.charAt(a - 1)) {
					currChain += dna.charAt(a);
				}

				if(a != 0 && (dna.charAt(a) != dna.charAt(a - 1) || a == dna.length() - 1)) {
					if(currChain.length() > 1) {
						chains.add(currChain);
					}

					currChain = "" + dna.charAt(a);
				}
			}

			for(String s : chains) {
				if(s.length() > largestChain.length()) {
					largestChain = s;
				}
			}
		}

		public int compareTo(DNAPair other) {
			int d = other.largestChain.length() - largestChain.length();

			if(d != 0) {
				return d;
			}

			return largestChain.charAt(0) - other.largestChain.charAt(0);
		}

		public String toString() {
			return dna + " - " + largestChain;
		}
	}
}
