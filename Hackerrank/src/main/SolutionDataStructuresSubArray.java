package main;

import java.io.*;
import java.util.*;

public class SolutionDataStructuresSubArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			int val = scan.nextInt();
			a[i] = val;
		}

		int count = 0;
		for (int j = 0; j < a.length; j++) {
			int temp = 0;
			for (int k = 0 + j; k < a.length; k++) {
				temp += a[k];
				if (temp < 0) {
					count++;
			}
			}
		}
		System.out.println(count);
	}
}
