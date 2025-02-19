package euler;

import java.math.BigDecimal;
import java.util.Scanner;

public class SolutionPowerDigitSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			BigDecimal number = getPowerTwo(n);
			char[] chars = String.valueOf(number).toCharArray();
			int sum = 0;
			for (int i = 0; i < chars.length; i++) {
				sum += Character.getNumericValue(chars[i]);
			}
			System.out.println(sum);
		}

	}

	private static BigDecimal getPowerTwo(int power) {
		BigDecimal[] f = new BigDecimal[power + 1];
		f[0] = new BigDecimal(1);
		f[1] = new BigDecimal(2);
		BigDecimal two = new BigDecimal(2);
		for (int i = 2; i < f.length; i++) {
			f[i] = two.multiply(f[i - 1]);
		}
		return f[f.length - 1];
	}

}
