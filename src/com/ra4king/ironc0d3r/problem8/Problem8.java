package com.ra4king.ironc0d3r.problem8;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.ra4king.ironc0d3r.Utility;

/**
 * @author Roi Atalla
 */
public class Problem8 {
	public static void main(String[] args) throws Exception {
		ArrayList<String> lines = Utility.readLines(Problem8.class.getResourceAsStream("Question8_input.txt"));

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		try(PrintWriter writer = new PrintWriter(new FileWriter("Question8_output.txt"))) {
			for(String s : lines) {
				String[] parts = s.split(" ");

				int count = 0;
				for(String part : parts) {
					Calendar cal = Calendar.getInstance();
					cal.setTime(format.parse(part));

					if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
						count++;
					}
				}

				writer.println(count);
			}
		}
	}
}
