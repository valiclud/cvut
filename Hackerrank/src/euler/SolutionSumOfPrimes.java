package euler;

import java.util.Scanner;

public class SolutionSumOfPrimes {

	public static boolean isprime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long n = in.nextLong();
			if (n == 2) {
				System.out.println(2);
				continue;
			}
			long sum = 0;
			for (int i = 2; i < n; i++) {
				if (isprime(i)) {
					sum += i;
					System.out.println(" -- " + i);
				}
			}
			//if (n > 2) {
			//	sum += n;
			//}
			System.out.println(sum);

		}
	}
}