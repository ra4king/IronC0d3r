package com.ra4king.ironc0d3r.problem2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import com.ra4king.ironc0d3r.Utility;

/**
 * This problem required us to sort the entire file by line by longest-chain length in descending order or alphabetically.
 * <p>
 * ACCTGCT        CTCCCGG
 * CTCCCGG   -->  ACCTGCT
 * ATCCGCT        ATCCGCT
 * GGTCAAC        GGTCAAC
 * <p>
 * Side note: Unfortunately, I completed this problem after the time limit, so I did not receive the points for this
 * problem. With this one and Problem 8, I could have potentially been in the top 4.
 *
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

	/**
	 * Held the DNA String and its longest chain String.
	 */
	private static class DNAPair implements Comparable<DNAPair> {
		private String dna;
		private String largestChain = "";

		/**
		 * The constructor finds the longest chain.
		 *
		 * @param dna The DNA String.
		 */
		public DNAPair(String dna) {
			this.dna = dna;

			String currChain = String.valueOf(dna.charAt(0));
			ArrayList<String> chains = new ArrayList<>();
			for(int a = 1; a < dna.length(); a++) {
				if(dna.charAt(a) == dna.charAt(a - 1)) {
					currChain += dna.charAt(a);
				}

				if(dna.charAt(a) != dna.charAt(a - 1) || a == dna.length() - 1) {
					chains.add(currChain);
					currChain = String.valueOf(dna.charAt(a));
				}
			}

			for(String s : chains) {
				if(s.length() > largestChain.length()) {
					largestChain = s;
				}
			}
		}

		/**
		 * Sorts by length in descending order otherwise alphabetically.
		 *
		 * @param other The other DNAPair to compare against.
		 * @return A negative value, zero, or positive value if respectively less than, equal to, or greater than <code>other</code>.
		 */
		public int compareTo(DNAPair other) {
			int d = other.largestChain.length() - largestChain.length();
			return d != 0 ? d : largestChain.charAt(0) - other.largestChain.charAt(0);
		}

		public String toString() {
			return dna + " - " + largestChain;
		}
	}
}
