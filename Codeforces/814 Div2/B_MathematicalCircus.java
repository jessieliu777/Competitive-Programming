import java.io.*;
import java.util.*;
 
 
public class B_MathematicalCircus{
   public static void main(String[] args) {
      MyScanner sc = new MyScanner();
      out = new PrintWriter(new BufferedOutputStream(System.out));
      
      // Start writing your solution here. -------------------------------------
   
      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */

      int t = sc.nextInt(); // number of test cases
      for (int i = 0; i < t; i++){
         int n = sc.nextInt(); // the first int
         int k = sc.nextInt(); // the second int
        // we need to check all cases of k mod 4
        // for 0, there's no solution 
        // since (a+0)*b mod 4 = 0 -> ab mod 4 = 0 all pairs need to be divisible by 4 = 2^2
        // however, the product of all the even numbers are 2 * 4 * ... n 
        // = 2 * 2^2 ... * 2^(n/2) 
        // < 2^(n/2) * ... 2^(n/2) = 2^n
         if (k % 4 == 0 ){
            out.println("NO");                                             
         }
         // for 1 or 3, we can pick pairs in the form of (i, i+1)
         // for 1: (a+1)*b mod 4 = 0 -> pick b = a+1 : (a+1)*(a+1) mod 4 = 0 --> a odd, (b = a+1 even) works
         // for 3: (a+3)*b mod 4 = 0 -> pick b = a+1 : (a+3)*(a+1) mod 4 = 0 --> a odd, (b = a+1 even) works
         else if (k % 4 == 1 || k % 4 == 3){
            out.println("YES");
            for (int j=1; j<n; j+=2){
                out.println(j + " " + String.valueOf(j+1));
            }
         } 
         // for 2: (a+2)*b mod 4 = 0 -> so like before each pair is (i, i+1), however they are not necessarily in that order
         // we need either a+2 mod 4 = 0 or b mod 4 = 0. 
         // Like before i is odd, i+1 is even
         // But not all even numvers are divisible by 4,
         // so for the ones who are not we just need to add 2, so we assign it to a
         // The remaining i+1's are divisible by 4, so we assign it to b
         else {
            out.println("YES");
            for (int j=1; j<n; j+=2){
                if ((j+1) % 4 == 0){
                    out.println(j + " " + String.valueOf(j+1));
                } else {
                    out.println(String.valueOf(j+1) + " " + j);
                }
                
            }
         }
      }

      // Stop writing your solution here. -------------------------------------
      out.close();
   }

     

   //-----------PrintWriter for faster output---------------------------------
   public static PrintWriter out;
      
   //-----------MyScanner class for faster input----------
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
     try {
        str = br.readLine();
     } catch (IOException e) {
        e.printStackTrace();
     }
     return str;
      }

   }
   //--------------------------------------------------------
}