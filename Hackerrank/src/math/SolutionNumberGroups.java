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

class ResultNG {

    /*
     * Complete the 'sumOfGroup' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER k as parameter.
     */

	public static long sumOfGroup(int k) {
		long n = 0;
		for(long i = 1; i < 2*k; i ++) {
			if (i%2 != 0) {
				n += k * (k-1) + i;
			}
		}
		return (long)k * k * k;
	}

}

public class SolutionNumberGroups {
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        long answer = ResultNG.sumOfGroup(k);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
