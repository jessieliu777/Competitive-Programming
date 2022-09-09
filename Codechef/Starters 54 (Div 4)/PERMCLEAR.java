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
            int n = Integer.parseInt(scanner.nextLine());
            String[] a = scanner.nextLine().split(" ");
            int k = Integer.parseInt(scanner.nextLine());
            String[] b = scanner.nextLine().split(" ");
            // only check the failed tests
            Set dislike = Arrays.stream(b).collect(Collectors.toSet());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++){
                if (!dislike.contains(a[i])){
                    result.append(a[i]);
                    result.append(" ");
                }
            }
            System.out.println(result.toString());
        }
	}
}
