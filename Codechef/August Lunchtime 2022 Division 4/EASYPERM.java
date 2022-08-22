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
            int N = scanner.nextInt();
            StringBuilder str = new StringBuilder();
            for (int j = N; j > 0; j--){
                str.append(String.valueOf(j));
                str.append(" ");
            }
            System.out.println(str.toString());
        }
	}
}
