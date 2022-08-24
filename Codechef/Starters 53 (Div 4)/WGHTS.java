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
            int W = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int Z = scanner.nextInt();
            
            if (W == X || W == Y || W == Z || W == X+Y || W == X+Z || W == Y+Z || W == X+Y+Z){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            
        }
	}
}
