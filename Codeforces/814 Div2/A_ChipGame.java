import java.io.*;
import java.util.*;
 
 
public class A_ChipGame{
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

      int n = sc.nextInt(); // number of test cases
      for (int i = 0; i < n; i++){
         int x = sc.nextInt(); // the first game
         int y = sc.nextInt(); // the second game
         int totalMoves = x-1 + y-1;
         // since Burenka makes the first move, she will win the first game if there's odd number of 'moves'
         if (totalMoves % 2 == 0){
            out.println("Tonya");
         } else {
         out.println("Burenka");
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