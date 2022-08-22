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
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (A == B || (A-B) % 2 == 0){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
	}
}
