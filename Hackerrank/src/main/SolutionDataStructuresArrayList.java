package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SolutionDataStructuresArrayList {
	
	public static void main(String []argh)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			List<Integer> datas = new ArrayList<>();
			String a = scan.nextLine();
			String[] array = a.split("\\s");
			for (int j = 0; j < array.length; j++) {
				datas.add(Integer.valueOf(array[j]));
			}
			map.put(i, datas);
		}
		int noOfQueries = scan.nextInt();
		scan.nextLine();
		List<String> queries = new ArrayList<>();

		for (int i = 0; i < noOfQueries; i++) {
			String operation = scan.nextLine();
			queries.add(operation);
		}
		
		for (int j = 0; j < queries.size(); j++) {
			String[] query = queries.get(j).split(" ");
			int line = Integer.valueOf(query[0]) -1;
			int position = Integer.valueOf(query[1]);
			List<Integer> foundDatas = map.get(line);
			if (line < map.size() && position < foundDatas.size()) {
				System.out.println(foundDatas.get(position));
			} else {
				System.out.println("ERROR!");
			}
		}
		scan.close();
	}
}
