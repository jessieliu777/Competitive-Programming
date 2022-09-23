class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = 0;
        for (char c: s.toCharArray()){
            // if there's a pair = 2 chars, then we can use it in palindrome
            if (++count[c] == 2){
                len += 2;
                count[c] = 0;
            }
        }
        // if we've used up all the letters, then it's the longest, otherwise, take an extra letter for the 'center'
        return len == s.length() ? len: len+1;
    }
}