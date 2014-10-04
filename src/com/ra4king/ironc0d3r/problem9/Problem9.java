package com.ra4king.ironc0d3r.problem9;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.ra4king.ironc0d3r.Utility;

/**
 * This problem required us to convert each spelled out number into its numerical value.
 * <p>
 * Fifty Four -> 54
 * One Hundred Three Thousand Ninety Nine -> 103099
 * Two Billion Three Million One Thousand and Two -> 2003001002
 *
 * @author Roi Atalla
 */
public class Problem9 {
	private static HashMap<String, Long> names = new HashMap<>();

	static {
		names.put("zero", 0L);
		names.put("one", 1L);
		names.put("two", 2L);
		names.put("three", 3L);
		names.put("four", 4L);
		names.put("five", 5L);
		names.put("six", 6L);
		names.put("seven", 7L);
		names.put("eight", 8L);
		names.put("nine", 9L);
		names.put("ten", 10L);
		names.put("eleven", 11L);
		names.put("twelve", 12L);
		names.put("thirteen", 13L);
		names.put("fourteen", 14L);
		names.put("fifteen", 15L);
		names.put("sixteen", 16L);
		names.put("seventeen", 17L);
		names.put("eighteen", 18L);
		names.put("nineteen", 19L);
		names.put("twenty", 20L);
		names.put("thirty", 30L);
		names.put("forty", 40L);
		names.put("fifty", 50L);
		names.put("sixty", 60L);
		names.put("seventy", 70L);
		names.put("eighty", 80L);
		names.put("ninety", 90L);
		names.put("hundred", 100L);
		names.put("thousand", 1000L);
		names.put("million", 1000000L);
		names.put("billion", 1000000000L);
		names.put("trillion", 1000000000000L);
		names.put("quadrillion", 1000000000000000L);
		names.put("quintillion", 1000000000000000000L);
	}

	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem9.class.getResourceAsStream("Question9_input.txt"));

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question9_output.txt"))) {
			for(String line : lines) {
				writer.println(convert(line));
			}
		}
	}

	private void test() {
		long i;
		System.out.println((i = convert("Fifty Four")) + " - " + (i == 54));
		System.out.println((i = convert("One Hundred Three Thousand Ninety Nine")) + " - " + (i == 103099));
		System.out.println((i = convert("Two Billion Three Million One Thousand and Two")) + " - " + (i == 2003001002));
	}

	/**
	 * For values of less than 100, I add them to an accumulator. Hundred multiplies the accumulator value by 100.
	 * Words signifying orders greater than 100 multiply with the accumulator and the product is added to the total value.
	 *
	 * @param name The name String to convert.
	 * @return The numerical value.
	 */
	private static long convert(String name) {
		String[] parts = name.trim().toLowerCase().split(" ");

		long value = 0;
		long prevValue = 0;

		for(String part : parts) {
			part = part.trim();

			if(part.isEmpty()) {
				continue;
			}

			switch(part) {
				case "thousand":
				case "million":
				case "billion":
				case "trillion":
				case "quadrillion":
				case "quintillion":
					value += prevValue * names.get(part);
					prevValue = 0;
					break;
				case "and":
					continue;
				case "hundred":
					prevValue *= 100;
					break;
				default:
					prevValue += names.get(part);
			}
		}

		return value + prevValue;
	}
}
