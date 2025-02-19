package euler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionLargestPalindrome {
/*
	public static void main(String[] argh) {
		int max = 0;
		int maxi = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 100; j++) {
				if (isPalindrome(String.valueOf(i*j)) && max < i*j) {
					max = i*j;
				}
			}
		}
		System.out.println(max);
		
	}
	*/
	
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int max = 0;
    		int count = 0;
    		for (int i = 999; i > 1; i--) {
    			for (int j = 999; j > 1; j--) {
    				count = i*j;
    				if (max < count && count < n && isPalindrome(String.valueOf(count))) {
    					max = i*j;
    				}
    			}
    		}
    		System.out.println(max);
        }
    }
		
		private static boolean isPalindrome(String s) {
			char [] chars = s.toCharArray();
			for (int i = 0; i < chars.length /2; i ++) {
				if (chars[i] != chars[chars.length -i-1])
					return false;
			}
			return true;
		}
	
}
