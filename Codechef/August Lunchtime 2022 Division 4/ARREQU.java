/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    /* HashMap<String, String> map = new HashMap<String, String>(); */
		Scanner scanner = new Scanner(System.in); 
        /* int n = scanner.nextInt();
        String str = scanner.nextLine(); 
        */
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++){
            // highest repeatance <= half of array length
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int N = scanner.nextInt();
            for (int j = 0; j < N; j++){
                map.merge(scanner.nextInt(), 1, Integer::sum);
            }
            boolean dislike = false;
            for (Integer value : map.values()) {
                if (N % 2 == 0){
                    if (value > N/2){
                        dislike = true;
                    }
                } else {
                    if (value > N/2 + 1){
                        dislike = true;
                    }
                }
            }
            if (dislike){
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
	}
}
