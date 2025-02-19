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

class ResultBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    	boolean flag = true;
    	List<Character> l = new ArrayList<>();
		for (char inputChar : s.toCharArray()) {
			l.add(inputChar);
			if ((inputChar == ')' || inputChar == '}' || inputChar == ']') && l.size() >= 2){
				char last = l.get(l.size() - 2);
				if ((last == '(' && inputChar == ')')
						|| (last == '{' && inputChar == '}' || (last == '[' && inputChar == ']'))) {
					l.remove(l.size() - 2);
					l.remove(l.size() - 1);
				} else {
					flag = false;
				}
			}
		}
		if (!l.isEmpty())
			flag = false;
		if (flag)
			return "YES";
		else
			return "NO";

    }

}

public class SolutionBalancedBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = ResultBrackets.isBalanced(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
