/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scanner = new Scanner(System.in); 
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++){
            String[] test = scanner.nextLine().strip().split(" ");
            int A = Integer.parseInt(test[0]);
            int B = Integer.parseInt(test[1]);
            int C = Integer.parseInt(test[2]);
            if (Math.max(A, C) <= B){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
	}
}
