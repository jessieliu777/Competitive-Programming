import java.io.*;
import java.util.*;
import java.util.stream.*;
 
 
public class C_FightingTournament{
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
         int n = sc.nextInt(); // the number of participants
         int q = sc.nextInt(); // the number of questions
         ArrayList<Integer> participants = new ArrayList<Integer>(0);
         ArrayList<Integer> simulation = new ArrayList<Integer>(Collections.nCopies(n, 0));
         LinkedHashMap<Integer, LinkedList<Integer>> wins = new LinkedHashMap<>(n); // maps each player's strength to wins
         int p1 = sc.nextInt();
         participants.add(p1);
         int p2 = -1;
         wins.put(p1, new LinkedList<>());
         for (int round = 0; round < n-1; round++){
            p2 = sc.nextInt();
            participants.add(p2);
            wins.put(p2, new LinkedList<>());
            if (p1 > p2){
                // update win round
                wins.get(p1).add(round);
                // move 1st person back to 1st, 2nd person to last
                simulation.add(0, p1);
                simulation.set(n-1, p2);
            } else {
                // update win round
                wins.get(p2).add(round);
                // move 1st person to last, 2nd person to 1st
                simulation.add(0, p2);
                simulation.set(n-1, p1);
                p1 = p2;
            }
        }
         // for every question
         for (int j = 0; j < q; j++){
            int athelete = sc.nextInt()-1; // since given i starts at 1, but index starts at 0
            int k = sc.nextInt();
            // get the total number of wins for the athelete
            int atheleteStrength = participants.get(athelete);
            int total = 0;
            int kIndex = Collections.binarySearch(wins.get(atheleteStrength), k-1);
            // if we can find kth round (k-1 since index start at 0)
            if (kIndex >= 0){
                total = kIndex + 1;
            } else {
                total = -kIndex -1;
            }
            // if the athelete is the strongest, then add k-n+1 if K > n-1 
            // (since we didn't simulate the remaining k-n+1 rounds)
            if (atheleteStrength == simulation.get(0) && k > n-1){
                total += k-n+1;
            }
            out.println(total);
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