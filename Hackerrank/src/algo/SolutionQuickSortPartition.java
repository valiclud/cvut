package algo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class ResultPartition {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> quickSort(List<Integer> arr) {
    int pivot = arr.get(0);
    for (int i = 1; i <arr.size() -1; i++) {
    	if(arr.get(i) <= arr.get(i-1)) {
    		int temp = arr.get(i);
    		arr.set(i, arr.get(i-1));
    		arr.set(i-1, temp);
    	}
    	int temp = pivot;
		arr.set(i, arr.get(i+1));
		pivot = temp;
    	
    	
    }
    	System.out.println(arr);
    	return arr;
    }

}

public class SolutionQuickSortPartition {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultPartition.quickSort(arr);
/*
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );
*/
        bufferedReader.close();
        bufferedWriter.close();
    }
}
