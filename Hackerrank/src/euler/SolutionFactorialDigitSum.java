package euler;

import java.util.Scanner;
import java.math.BigDecimal;

public class SolutionFactorialDigitSum {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	long n = in.nextLong();
    		BigDecimal fakt = new BigDecimal(1);
    		for (int i = 2; i < n+1; i++) {
    			fakt =fakt.multiply(new BigDecimal(i));
    		}
    		int sum = 0;
    		char [] results = String.valueOf(fakt).toCharArray();
    		for (int j = 0; j < results.length; j++) {
    			sum += Character.getNumericValue(results[j]);
    		}
    		System.out.println(sum);
        }
    }
}