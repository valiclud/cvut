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

class ResultAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

	
	public static int sherlockAndAnagrams(String s) {
		int result=0;
		char [] chars = s.toCharArray();
		HashMap<String ,Integer> map=new HashMap<>();
		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				String part = s.substring(i, j+1);
				char [] charParts = part.toCharArray();
				Arrays.sort(charParts);
				String str=new String(charParts);
				if(map.get(str) == null) {
					map.put(str,1);
				}else {
					map.put(str, map.get(str) + 1);
				}
			}
		}
		 for (int a:map.values()){
		        result+=a*(a-1)/2;
		    }
		return result;
	}

}

public class SolutionAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));


        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultAnagrams.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
