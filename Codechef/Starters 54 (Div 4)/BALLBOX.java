/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;

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
        while (T>0){
            T--;
            String[] A = scanner.nextLine().split(" ");
            int n = Integer.parseInt(A[0]);
            int k = Integer.parseInt(A[1]);
            // only check the failed tests
            if (n >= k * (k+1)/2){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
	}
}
