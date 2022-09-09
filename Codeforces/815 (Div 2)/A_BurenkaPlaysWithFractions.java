import java.io.*;
import java.util.*;
 
 
public class A_BurenkaPlaysWithFractions{

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
         long a = sc.nextLong(); // the first numerator
         long b = sc.nextLong(); // the first denominator
         long c = sc.nextLong(); // the second denominator
         long d = sc.nextLong(); // the second denominator
         
         // if they are equal then no need to clap
         if (a*d == b*c){
            out.println(0);
         } 
         // if they aren't equal there's at least 1 clap
         else {
            // there is 1 clap if there's any 0's or (there exists x where ax/c == b/d or a/c == bx/d)
            if (a == 0 || c == 0){
               out.println(1);
            }
            else if ((b*c) % (a*d) == 0 || (a*d) % (b*c) == 0){
               out.println(1);
            } 
            // if not 0, or 1 clap then it has to be 2 
            // since we can always transform a/b to ac by a/b * bc, 
            // and c/d to ac by c/d * ad
            else {
               out.println(2);
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