package euler;

import java.math.BigDecimal;
import java.util.Scanner;

public class SolutionSumSquareDifference {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	long n = in.nextLong();
        	long sumSquare = 0;
        	long sum = n * (n+1) /2;
        	for (int i = 0; i < n+1; i++) {
        		sumSquare += Math.pow(i, 2.0);
        	}
        	System.out.println((long)Math.pow(sum, 2.0) - sumSquare);
        }
	}
	
}
