package algo;
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

class ResultFiboModif {

    /*
     * Complete the 'fibonacciModified' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER t1
     *  2. INTEGER t2
     *  3. INTEGER n
     */

	public static BigDecimal fibonacciModified(int t1, int t2, int n) {
		BigDecimal f[] = new BigDecimal[n];
		f[0] = new BigDecimal(t1);
		f[1] = new BigDecimal(t2);
		if (n == 0)
			return new BigDecimal(0);
		if(n == 1)
			return new BigDecimal(t1);
		if(n == 2)
			return new BigDecimal(t2);
		
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 2].add((f[i - 1].multiply(f[i - 1])));
		}
		return f[f.length-1];
	}
}

public class SolutionFibonacciModif {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        BigDecimal result = ResultFiboModif.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
