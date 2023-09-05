package math;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultPrimes {

	/*
	 * Complete the 'primeCount' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * LONG_INTEGER n as parameter.
	 */

	public static boolean isprime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return true;
		}
		return false;
	}

	public static int primeCount1(long n) {
		long multiple = 1;
		Set<Integer> count = new HashSet<>();
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (isprime(i) && multiple <= n) {
				count.add(i);
				multiple *= i;
			}
		}
		System.out.println(" -- " + count);
		return count.size();
	}

	public static int primeCount(long n) {
		List<Integer> allPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
				71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151);
		BigDecimal multiple = new BigDecimal(1);
		int count = 0;
		for (int i = 0; i < allPrimes.size(); i++) {
			multiple = multiple.multiply(new BigDecimal(allPrimes.get(i)));
			if (multiple.compareTo(new BigDecimal(n)) == -1 ||
					multiple.compareTo(new BigDecimal(n)) == 0) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}

public class SolutionPrimeFactor {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, q).forEach(qItr -> {
			try {
				long n = Long.parseLong(bufferedReader.readLine().trim());

				int result = ResultPrimes.primeCount(n);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
