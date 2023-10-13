package euler;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Stream;

public class SolutionDoubleBasedPalindrom {
	
	private static boolean isPalindrome(String s) {
		char []chars = 	s.toCharArray();
		for (int i = 0; i < chars.length/2; i++) {
			if (chars[i] != chars[chars.length - i - 1])
				return false;
		}
		return true;
	}
	
	private static long asBase(long num, int base) {
	    long ret = 0, factor = 1;
	    while (num > 0) {
	        ret += num % base * factor;
	        num /= base;
	        factor *= 10;
	    }
	    return ret;
	}
	
	private static long getKBasedSum(int n, int k) {
		long sum = 0;
		for (int i = 1; i <= n; i++) {
			String s = Long.toString(asBase(i, k));
			if (isPalindrome(s) && isPalindrome(Long.toString(i))) {
				sum += i;
			}
		}
		return sum;
	}	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        System.out.println(getKBasedSum(arr.get(0), arr.get(1)));
        
    }
}