package euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SolutionSumLargeNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		List<String>  numbers = new ArrayList<>();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			numbers.add(s);
		}
		
		String temp = numbers.get(0);
		for (int j = 1; j < numbers.size(); j++) {
				temp = sum(numbers.get(j), temp);
		}
		System.out.println(temp.substring(0, 10));
	}
	
	private static String sum(String s1, String s2) {
		if (s2.length() > s1.length()) {
			int zeros = s2.length() - s1.length() ;
			String format = "%0" + zeros + "d%s";
			s1 = String.format(format, 0, s1);
		}
		char [] chars1 = s1.toCharArray();
		char [] chars2 = s2.toCharArray();
		int [] result = new int [chars2.length];
		int c = 0;
		int overflow = 0;
		String finalString = "";
		for (int i = chars2.length -1; i >= 0; i--) {
			c = Character.getNumericValue(chars1[i]) + Character.getNumericValue(chars2[i]) + overflow;
			if (c >9) {
				overflow = 1;
				c = c%10;
			} else {
				overflow = 0;
			}
			result[i] = c;
			finalString = Arrays
		            .stream(result)
		            .mapToObj(String::valueOf)
		            .reduce((a, b) -> a.concat("").concat(b))
		            .get();
			
			if (i == 0 && overflow > 0) {
				finalString = (char)(overflow + '0') + finalString;
			} 
		}
		return finalString;
	}
	
	
}
