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
            int mean = Integer.parseInt(A[0]);
            int median = Integer.parseInt(A[1]);
            int second = median;
            int withoutSecond = mean*3-second;
            int first = withoutSecond/2;
            // make sure first is not gt second
            while (first > second){
                first--;
            }
            int third = withoutSecond-first;
            // make sure third is not lt second
            while (third < second){
                third++;
                first--;
            }
            System.out.println(first + " " + second + " " + third);
        }
	}
}
