package main;

import java.io.*;
import java.util.*;

public class SolutionStringTokens {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine().trim();
		s = s.replaceAll("[^A-Z^a-z]", " ");
		s = s.replaceAll("\\^", " " );
		s = s.replaceAll("\\s+", " " );
		String [] splitted;
		if (s.equals(" ") || s.equals(""))
			splitted = new String[0];
		else
			splitted = s.split(" ");
		
		
		System.out.println(splitted.length);
		
		for(String splt : splitted) {
			System.out.println(splt.trim());
		}
		
		scan.close();
		
		
	}
}
