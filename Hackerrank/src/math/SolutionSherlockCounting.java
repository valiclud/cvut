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

class Result {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */

	public static int solve1(int n, int k) {
		int result = 0;
		int remainder = 0;
		if ( n % 2 == 0)
			remainder = -1;
		System.out.println("**** " + n % 2);
		
		for (int i = 1; i <= n /2; i++) {
			if (i >= n)
				return 2 * result + remainder;
			if (n * k >= i * (n - i)) {
				result++;
			}
		}
		return 2 * result + remainder;

	}
	
	public static int solve(int n, int k) {
		double result = 0.0d;
		double d = Math.sqrt(Math.pow(n, 2) - 4*(double)n*(double)k);
		long min = 0;
		long max = 0;
		if (d > 0) {
			double x1 = ((-1 * n) + d) / (-2);
			double x2 = ((-1 * n) - d) / (-2);
			if (x1 < x2) {
				min = (long) x1;
				max = (long) Math.ceil(x2);
			} else {
				min = (long) x2;
				max = (long) Math.ceil(x1);
			}
			if (min < 0) {
				min = 0;
			}
			if (max < 0) {
				max = 0;
			}
			result = min + n - max;
		} else {
			result = n - 1;
		}
		return (int) result;
	}	
}

public class SolutionSherlockCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.solve(n, k);

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
