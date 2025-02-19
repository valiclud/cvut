package euler;

import java.math.BigDecimal;
import java.util.Scanner;

public class SolutionNDigitFibNumbers {
	
	
	private static int [] lengths = null;
	static {
		lengths = getFibLengths();
	}
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	int n = in.nextInt();
        	System.out.println(lengths[n]);
        }
	}
	
	private static int[] getFibLengths() {
		int [] lengths = new int[6000];
		BigDecimal f[] = new BigDecimal[24000];
 		f[0] = new BigDecimal(0);
 		f[1] = new BigDecimal(1);
 		f[2] = new BigDecimal(1);
 		lengths[0] = 1;
 		lengths[1] = 1;
 		lengths[2] = 1;
 		for (int i = 3; i < f.length; i++) {
 			f[i] = f[i - 1].add(f[i - 2]);
 			int length = f[i].toPlainString().length();
 			if (lengths[length] == 0) {
 				lengths[length] = i;
 				//System.out.println(length + " " + i);
 			}
 		}
		return lengths;
	}
	
/*	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	long n = in.nextLong();
            BigDecimal f[] = new BigDecimal[2000];
    		f[0] = new BigDecimal(0);
    		f[1] = new BigDecimal(1);
    		f[2] = new BigDecimal(1);
    		for (int i = 3; i < f.length; i++) {
    			f[i] = f[i - 1].add(f[i - 2]);
    			int length = f[i].toPlainString().length();
    			if (length == n) {
    				System.out.println(i);
    				break;
    			}
    		}
        }
	}
	*/
}
