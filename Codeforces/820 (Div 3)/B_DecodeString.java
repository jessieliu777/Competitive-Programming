import java.io.*;
import java.util.*;
 
public class B_DecodeString{
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
         
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int t = Integer.parseInt(sc.nextLine()); 
        while (t > 0){
            t--;
            int len = Integer.parseInt(sc.nextLine()); 
            String code = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int i = code.length()-1;
            while (i >= 0){
                // if 0, then read the left 2 code
                if (code.charAt(i)-'0' == 0){
                    int index = (code.charAt(i-2)-'0')*10 + (code.charAt(i-1)-'0') -1;
                    result.append(alphabets.charAt(index));
                    i-=2;
                }
                // if not 0, then write it
                else {
                    result.append(alphabets.charAt(code.charAt(i)-'0'-1));
                }
                i--;
            }
            System.out.println(result.reverse().toString());
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