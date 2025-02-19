package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionTagContentExtractor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		List<Character> l = new ArrayList<>();
		List<String> tags = new ArrayList<>();
		List<Integer> tagsNo = new ArrayList<>();
		boolean flag = true;
		int tagNumber = 0;
		while (testCases > 0) {
			String inline = in.nextLine();

			// Pattern pattern = Pattern.compile("<\\/(.+?)>");
			// Matching the compiled pattern in the String
			// String[] lines = pattern.split(inline);

			// String [] lines = inline.split("(?<=(<\\/(.{0,100}?)>))");
			// String removedTags = line.replaceAll("<[^>]+>", "");
			char[] chars = inline.toCharArray();
			int tagStart = 0;
			boolean flagEndTag = false;
			int lineStart = 0;
			for (int i = 1; i < chars.length; i++) {
				if (chars[i - 1] == '<' && chars[i] != '/') {
					tagStart = i;
					tagNumber ++;
				} else if (chars[i - 1] == '<' && chars[i] == '/') {
					tagStart = i + 1;
					flagEndTag = true;
					tagNumber --;
				} else if (chars[i] == '>') {
					String tag = inline.substring(tagStart, i);
					if (!flagEndTag) {
						tags.add(tag);
						lineStart = i;
					}
					if (flagEndTag) {
						if(tagNumber == 0) {
						if (tags.get(tags.size() - 1).equals(tag)) {
							System.out.println(inline.substring(lineStart +1,tagStart -2));
							tags.clear();
						} else {
							System.out.println("None");
						}
						} else {
						flagEndTag = false;
						tags.remove(tag);
						}
					} 
				}
			}
			testCases--;
		}
	}
}
