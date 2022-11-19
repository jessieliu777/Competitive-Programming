class Solution {
    public char findTheDifference(String s, String t) {
        // take xor of every char, since x xor x cancels out, the remaining value is the new letter since it doesn't get cancelled out
        char c = 0;
          for(char cs : s.toCharArray()) c ^= cs;
          for(char ct : t.toCharArray()) c ^= ct;

          return c;
    }
}