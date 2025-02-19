package datastructures;

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

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
	
	private static int getStackHeight(Stack<Integer> stack) {
		int height = 0;
		for(Integer i : stack) {
			height += i;
		}
		return height;
	}
	private static Stack<Integer> getStack(List<Integer> h){
		Stack<Integer> stack = new Stack<Integer>();
		 for (int i = h.size() - 1; i >= 0; i--) {
	            stack.push(h.get(i));
	        }
		 return stack;
	}

	public static int equalStacks1(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		Stack<Integer> stack1 = getStack(h1);
		Stack<Integer> stack2 = getStack(h2);
		Stack<Integer> stack3 = getStack(h3);
		while (true) {
			int height1 = getStackHeight(stack1);
			int height2 = getStackHeight(stack2);
			int height3 = getStackHeight(stack3);
			if (height1 == height2 && height2 == height3)
				return height1;
			if (height1 > height2 && height1 > height3)
				stack1.pop();
			if (height2 > height1 && height2 > height3)
				stack2.pop();
			if (height3 > height2 && height3 > height1)
				stack3.pop();
		}

	}
	
	private static int getHeight(List<Integer> l) {
		int height = 0;
		for(int i = 0; i < l.size(); i++) {
			height += l.get(i);
		}
		return height;
	}
	
	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		int height1 = getHeight(h1);
		int height2 = getHeight(h2);
		int height3 = getHeight(h3);
		while (true) {
			if (height1 == height2 && height2 == height3) {
				return height1;
			}
			if (height1 > height2 || height1 > height3) {
				height1 -= h1.remove(0);
			}
			if (height2 > height1 || height2 > height3) {
				height2 -= h2.remove(0);
			}
			if (height3 > height1 || height3 > height2) {
				height3 -= h3.remove(0);
			}
		}
	}

}

public class SolutionEqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
