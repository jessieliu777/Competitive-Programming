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
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            if ((float)(A+B)/2 > C){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
	}
}
