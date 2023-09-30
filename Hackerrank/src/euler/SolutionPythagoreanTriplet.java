package euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionPythagoreanTriplet {

	private static long calculateTriplet(int n) {
		int a = 0, b = 0, c = 0;
		long max = -1L;
		int i = 1;
		while (c < n) {
			for (int j = 0; j < i; ++j) {
				a = i * i - j * j;
				b = 2 * i * j;
				c = i * i + j * j;
				if (c > n)
					break;
				long x = a * b * c;
				if ((a+b+c) == n)
					System.out.println(x + " " + a + " "+ b + " " + c);
				if (a != 0 && ((a + b + c) == n) && x > max) {
					max = x;
				}
			}
			i++;
		}
		return max;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long result = calculateTriplet(n);
            System.out.println(result);
        }
    }
}