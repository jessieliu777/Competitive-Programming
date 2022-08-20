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
      
      int n = sc.nextInt(); // number of cards
      int first = -1;
      int second = -1;
      int third = -1;
      for (int i = 0; i < n; i++){
        int card = sc.nextInt();
    	  if (card > first) {
            third = second;
            second = first;
            first = card;
    	  } else if (card > second) {
            third = second;
            second = card;
    	  } else if (card > third) {
            third = card;
    	  } 
      }
      String str1 = String.valueOf(first);
      String str2 = String.valueOf(second);
      String str3 = String.valueOf(third);
      String result = str1 + str2 + str3;
      if (result.compareTo(str1 + str3 + str2) < 0){
        result = str1 + str3 + str2;
      }
      if (result.compareTo(str2 + str1 + str3) < 0){
        result = str2 + str1 + str3;
      }
      if (result.compareTo(str2 + str3 + str1) < 0){
        result = str2 + str3 + str1;
      }
      if (result.compareTo(str3 + str1 + str2) < 0){
        result = str3 + str1 + str2;
      }
      if (result.compareTo(str3 + str2 + str1) < 0){
        result = str3 + str2 + str1;
      }
      out.println(result);
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