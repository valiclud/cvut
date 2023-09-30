package euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionOddFibNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	long n = in.nextLong();
            long f[] = new long[8000];
    		f[0] = 0L;
    		f[1] = 1L;
    		f[2] = 1L;
    		long sum = 0L;
    		for (int i = 3; i < f.length; i++) {
    			f[i] = f[i - 1] + f[i - 2];
    			if (f[i] > n ) {
    				System.out.println(sum);
    				break;
    			}
    			if (f[i]%2 == 0)
    				sum += f[i];
    		}
        }
    }
}