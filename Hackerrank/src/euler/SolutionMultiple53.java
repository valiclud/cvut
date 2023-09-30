package euler;

import java.util.Scanner;

public class SolutionMultiple53 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			long result = 0;
			long sum3 = (n - 1) / 3;
			long sum5 = (n - 1) / 5;
			long sum15 = (n - 1) / 15;
			result = 3 * (sum3 * (sum3 + 1)) / 2 + 5 * (sum5 * (sum5 + 1)) / 2 - 15 * (sum15 * (sum15 + 1)) / 2;

			System.out.println(result);
		}
	}

	private void bruteForce() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			long result = 0;
			for (int i = 0; i < n; i++) {
				if (i % 3 == 0 || i % 5 == 0) {
					result += i;
				}
			}
			System.out.println(result);
		}

	}
}
