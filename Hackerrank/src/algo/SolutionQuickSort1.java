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

class ResultQuickSort {

    /*
     * Complete the 'quickSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

	
	public static List<Integer> quickSort(List<Integer> arr) {
		int temp = 0;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) <= arr.get(i-1)) {
				temp = arr.get(i);
				arr.set(i, arr.get(i-1));
				arr.set(i-1, temp);
			} else {
				temp = arr.get(i-1);
				arr.set(i-1, arr.get(i-1));
				arr.set(i, temp);
			}
		}
		return arr;
	}

}

public class SolutionQuickSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = ResultQuickSort.quickSort(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
