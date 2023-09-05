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
        	BigDecimal n = new BigDecimal(in.nextLong());
            BigDecimal f[] = new BigDecimal[80];
    		f[0] = new BigDecimal(0);
    		f[1] = new BigDecimal(1);
    		f[2] = new BigDecimal(1);
    		BigDecimal sum = new BigDecimal(0);
    		for (int i = 3; i < f.length; i++) {
    			f[i] = f[i - 1].add(f[i - 2]);
    			if (f[i].compareTo(n) == 1) {
    				System.out.println(sum);
    				break;
    			}
    			if (i%3 == 0)
    				sum = sum.add(f[i]);
    		}
        }
    }
}