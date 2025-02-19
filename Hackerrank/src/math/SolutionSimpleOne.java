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

class ResultSimpleOne {

    /*
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER p
     *  2. INTEGER q
     *  3. INTEGER n
     */

    public static long solve(int p, int q, int n) {
    	long f[] = new long[n];
    	long tgalpha = p/q ;
		f[0] = 0;
		f[1] = tgalpha;
		if (n == 1)
			return tgalpha;
		//if (n == 2)
		//	return (2*tgalpha)/(1 - tgalpha * tgalpha)%1000000007L;
		//f[2] = (2*tgalpha)/(1 - tgalpha * tgalpha)%1000000007L;
		
		for (int i = 2; i < f.length; i++) {
			f[i] = (f[i - 1] + tgalpha) / (1 - f[i - 1] * tgalpha)%1000000007L;
		}
		return f[n-1];
    }

}

public class SolutionSimpleOne {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int p = Integer.parseInt(firstMultipleInput[0]);

                int q = Integer.parseInt(firstMultipleInput[1]);

                int n = Integer.parseInt(firstMultipleInput[2]);

                long result = ResultSimpleOne.solve(p, q, n);

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
