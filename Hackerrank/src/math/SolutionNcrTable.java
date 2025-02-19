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

class ResultNcr {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER n as parameter.
     */
	
	public static int fact(int n) {
		int res = 1, i;
		for (i = 2; i <= n; i++)
			res = (res * i)% 1000000000;
		return res;
	}

	public static List<Integer> solve1(int n) {
		if (n == 1)
			return Arrays.asList(1);
		Integer p[] = new Integer[n + 1];
		p[0] = 1;
		p[n] = 1;

		for (int i = 1; i <= n / 2; i++) {
			int result = fact(n) / (fact(n - i) * fact(i));
			p[i] = result;
			p[n - i] = result;
		}
		return Arrays.asList(p);
	}
	
	public static List<Long> solve(int n) {
		if (n == 0)
			return Arrays.asList(1L);
		List<Long> results = new ArrayList<>();
		Long p[][] = new Long[n+1][n+1];
		p[0][0] = 1L;
		p[1][0] = 1L;
		p[1][1] = 1L;
		for (int i = 2; i < p.length ; i++) {
			p[i][0] = 1L;
			for (int j = 1; j <= i; j++) {
				if (i != j) {
					p[i][j] = (p[i-1][j] + p[i-1][j-1]) % 1000000000L;
				} else {
					p[i][j] = 1L;
				}
			}
		}
		results.addAll(Arrays.asList(p[n]));
		return results;
	}
}

public class SolutionNcrTable {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Long> result = ResultNcr.solve(n);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
