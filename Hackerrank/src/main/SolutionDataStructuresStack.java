package main;

import java.util.*;

public class SolutionDataStructuresStack {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);

		List<Character> l = new ArrayList<>();
		while (sc.hasNext()) {
			boolean flag = true;
			String input = sc.next();
			char[] chars = input.toCharArray();
			for (char inputChar : chars) {
				l.add(inputChar);
				if ((inputChar == ')' || inputChar == '}' || inputChar == ']') && l.size() >= 2){
					char last = l.get(l.size() - 2);
					if ((last == '(' && inputChar == ')')
							|| (last == '{' && inputChar == '}' || (last == '[' && inputChar == ']'))) {
						l.remove(l.size() - 2);
						l.remove(l.size() - 1);
					} else {
						flag = false;
					}
				}
			}
			if (!l.isEmpty())
				flag = false;
			if (flag)
				System.out.println("true");
			else
				System.out.println("false");
			l.clear();
		}
		sc.close();
	}
}
