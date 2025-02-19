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

class ResultFibo {

    /*
     * Complete the 'isFibo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */
	//n -> Fibonacci
	static Map<Integer, Integer> memo = new HashMap<>(45);

	public static String isFibo1(long n) {
		if (n == 1 || n == 2)
			return "IsFibo";

		int num1 = 0, num2 = 1;
		for (int i = 1; i <= 45; i++) {
			memo.put(i,num2);
			if (memo.containsValue(n) || n == num2) {
				return "IsFibo";
			} 
			else {
				int num3 = num2 + num1;
				num1 = num2;
				num2 = num3;
			}
		}
		return "IsNotFibo";
	}
	
	public static String isFibo(long n) {
		long f[] = new long[55];
		f[0] = 0;
		f[1] = 1;
		if(n == 0 || n == 1)
			return "IsFibo";
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
			if (i%3 == 0)
				System.out.println(f[i]);
			if (f[i] == n)
				return "IsFibo";
		}
		return "IsNotFibo";

	}

}

public class SolutionIsFibo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

      int t = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream.range(0, t).forEach(tItr -> {
          try {
              long n = Long.parseLong(bufferedReader.readLine().trim());

              String result = ResultFibo.isFibo(n);

              bufferedWriter.write(result);
              bufferedWriter.newLine();
          } catch (IOException ex) {
              throw new RuntimeException(ex);
          }
      });

      bufferedReader.close();
      bufferedWriter.close();
  }
}
