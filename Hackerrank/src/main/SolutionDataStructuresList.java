package main;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionDataStructuresList {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> items = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int input = scan.nextInt();
			items.add(input);
		}
		int noOfQueries = scan.nextInt();
		scan.nextLine();
		List<String> queries = new ArrayList<>();

		for (int i = 0; i < noOfQueries; i++) {
			String operation = scan.nextLine();
			queries.add(operation);
			String values = scan.nextLine();
			queries.add(values);
		}

		for (int j = 0; j < queries.size(); j = j + 2) {
			String[] query = queries.get(j + 1).split(" ");
			int index = Integer.valueOf(query[0]);
			if (queries.get(j).equals("Insert")) {
				int element = Integer.valueOf(query[1]);
				if (index >= items.size())
					items.add(element);
				else
					items.add(index, element);
			} else {
				items.remove(index);
			}
		}
		
		for (int i = 0; i<items.size(); i ++) {
			if (i != items.size()-1)
				System.out.print(items.get(i) + " ");
			else
				System.out.print(items.get(i));
		}
		
		scan.close();
	}

}
