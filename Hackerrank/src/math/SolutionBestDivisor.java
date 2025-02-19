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


public class SolutionBestDivisor {
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <=n; i++) {
        	if (n % i == 0) {
        		divisors.add(i);
        	}
        }
        int maxSum = 0;
        int maxNumber = 0;
        for (Integer number : divisors) {
        	int no = number;
        	int sum=0;
        	int digit = 0;
        	while(number > 0)  {
        	digit = number % 10;  
        	sum = sum + digit;  
        	if (sum > maxSum) {
        		maxSum = sum;
        		maxNumber = no;
        	}
        	number = number / 10;  
        	}
        }
        System.out.println(maxNumber);
        
        
        bufferedReader.close();
    }
}

