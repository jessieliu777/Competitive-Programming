import java.io.*;
import java.util.*;
 
 
public class C_WordGame{
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
        int len = Integer.parseInt(sc.nextLine()); 
        String[] line1 = sc.nextLine().split(" ");
        String[] line2 = sc.nextLine().split(" ");
        String[] line3 = sc.nextLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        // get all the words
        for (int i = 0; i < len; i++){
            set.add(line1[i]);
            set.add(line2[i]);
            set.add(line3[i]);
        }
        // count the points
        for (int i = 0; i < len; i++){
            // if p1 wrote the word
            if (set.contains(line1[i])){

            }
        }
        if (yes){
            System.out.println("yes");
        } else {
            System.out.println("no");
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