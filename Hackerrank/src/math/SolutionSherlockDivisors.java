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

class ResultDivisors {

    /*
     * Complete the 'divisors' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

	public static int divisors(int n) {
		if (n % 2 != 0)
			return 0;
		int count = 0;
		while (true) {
			if (n % 2 == 0) {
				count++;
				n = n / 2;
			} else {
				break;
			}
		}
		return count;
	}
	
}

public class SolutionSherlockDivisors {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = ResultDivisors.divisors(n);

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
