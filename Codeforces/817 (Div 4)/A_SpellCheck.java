import java.io.*;
import java.util.*;
 
 
public class A_SpellCheck{
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

      int t = Integer.parseInt(sc.nextLine()); 
      while (t > 0){
        t--;
        int line1 = Integer.parseInt(sc.nextLine()); 
        String line2 = sc.nextLine();
        int len = line2.length();
        if (len != 5) {
            System.out.println("no");
            continue;
        }
        char temp[] = line2.toCharArray();
        // Sorting temp array using
        Arrays.sort(temp);
        if (temp[0] != 'T'){
            System.out.println("no");
            continue;
        }
        if (temp[1] != 'i'){
            System.out.println("no");
            continue;
        }
        if (temp[2] != 'm'){
            System.out.println("no");
            continue;
        }
        if (temp[3] != 'r'){
            System.out.println("no");
            continue;
        }
        if (temp[4] != 'u'){
            System.out.println("no");
            continue;
        }
        System.out.println("yes");
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