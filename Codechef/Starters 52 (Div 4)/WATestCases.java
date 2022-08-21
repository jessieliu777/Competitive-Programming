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
            int smallestFailed = -1;
            int N = Integer.parseInt(scanner.nextLine());
            String[] ints = scanner.nextLine().split(" ");
            String str = scanner.nextLine();
            for (int j = 0; j < N; j++){
                // only check the failed tests
                if (str.charAt(j) == '0'){
                    int cur = Integer.parseInt(ints[j]);
                    if (cur < smallestFailed || smallestFailed == -1){
                        smallestFailed = cur;
                    }
                }
            }
            System.out.println(smallestFailed);
        }
        
	}
}
