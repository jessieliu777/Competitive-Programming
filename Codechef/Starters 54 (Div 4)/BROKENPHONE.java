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
        while (T>0){
            T--;
            String[] A = scanner.nextLine().split(" ");
            int x = Integer.parseInt(A[0]);
            int y = Integer.parseInt(A[1]);
            if (x < y) {
                System.out.println("repair");
            }
            else if (x > y){
                System.out.println("new phone");
            } else {
                System.out.println("any");
            }
        }
	}
}
