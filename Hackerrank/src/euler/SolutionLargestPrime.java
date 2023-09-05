package euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionLargestPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            if (n == 2) {
            	System.out.println(2);
            	continue;
            }
            long primeMax = 0;
            for(int i = 2; i< n; i++) {
                while(n%i == 0) {
                   n = n/i;
                   primeMax = i;
                }
             }
             if(n >2) {
                primeMax = n;
             }
            System.out.println(primeMax);
            
        }
    }
}