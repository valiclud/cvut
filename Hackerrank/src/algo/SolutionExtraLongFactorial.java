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

class ResultFactorial {

    /*
     * Complete the 'extraLongFactorials' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

	public static void extraLongFactorials(int n) {
		BigDecimal result = new BigDecimal(1);
		for (int i = 2; i < n + 1; i++) {
			result = result.multiply(new BigDecimal(i));
		}
		System.out.println(result);
	}

}

public class SolutionExtraLongFactorial {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        ResultFactorial.extraLongFactorials(n);

        bufferedReader.close();
    }
}
