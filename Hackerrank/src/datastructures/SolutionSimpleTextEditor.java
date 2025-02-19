package datastructures;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolutionSimpleTextEditor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<String> strings = new ArrayList<>();
		String S = new String();
		for (int a0 = 0; a0 < t; a0++) {
			String inputString = "";
			int n = in.nextInt();
			if (n != 4) {
				inputString = in.next();
			}
			switch (n) {
			case 1:
				S += inputString;
				strings.add(S);
				break;
			case 2:
				int i = Integer.valueOf(inputString);
                S = strings.get(strings.size()-1).substring(0, S.length() - i);
				strings.add(S);
				break;
			case 3:
				int j = Integer.valueOf(inputString);
				System.out.println(strings.get(strings.size()-1).substring(j-1, j));
				break;
			case 4:
				strings.remove(strings.size() - 1);
				if (!strings.isEmpty())
					S = strings.get(strings.size()-1);
				else
					S="";
				break;
			}
		}
	}
}
