import java.io.*;
import java.util.*;
 
public class Main{
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
      
      // use a sliding window, start from left most to 2 columns down
      
      String s = sc.nextLine(); 
      int left = 0;
      int right = 2;
      if (s.charAt(0) == 1) {
        out.println("No");
      } else {
        String result = "No";
        // check if for 5 since it's at the same row as 1
        if (s.charAt(4) == 1){
          // check for the left side
          // since it's standing, we have to verify 4
          if (s.charAt(3) == 1){
            // 1, 4, 5 standing then 2, 8 must be down to be yes
            if (s.charAt(1) == 0 && s.charAt(7) == 0){
              result = "Yes";
            }
          } else {
            // 4 is down, then 7 must be standing to be yes
            if (s.charAt(6) == 1){
              result = "Yes";
            }
          }
          // check for the right side
          // since it's standing, we have to verify 6
          if (s.charAt(5) == 1){
            // 1, 5, 6 standing then 3, 9 must be down to be yes
            if (s.charAt(2) == 0 && s.charAt(8) == 0){
              result = "Yes";
            }
          } else {
            // 6 is down, then 10 must be standing to be yes
            if (s.charAt(9) == 1){
              result = "Yes";
            }
          }
        } else {
          // since both 1, 5 are down, we need at least one standing pin on either side
          boolean standingLeft = s.charAt(6) == 1 || s.charAt(3) == 1 || (s.charAt(1) == 1 && s.charAt(7) == 1);
          boolean standingRight = s.charAt(5) == 1 || s.charAt(9) == 1 || (s.charAt(2) == 1 && s.charAt(8) == 1);
          if (standingLeft && standingRight) {
            result = "Yes";
          } else {
            // edge cases
            if (s.charAt(6) == 1 && s.charAt(3) == 0 && s.charAt(1) == 1 && s.charAt(7) == 1){
              result = "Yes";
            } else if (s.charAt(9) == 1 && s.charAt(5) == 0 && s.charAt(2) == 1 && s.charAt(8) == 1){
              result = "Yes";
            }
          }
        }
        out.println(result);
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