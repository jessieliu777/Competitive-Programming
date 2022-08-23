class Solution {
    public boolean isPalindrome(String s){
        return true;
    }
    public String longestPalindrome(String s) {
        int count = 0;
        int len = s.length();
        // let palindrome = true iff s[i, j] is palindrome
        boolean palindrome[][] = new boolean[len][len];
        int longestLen = 0;
        int longestStart = 0;
        // all of palindrome[i][i] is true
        for (int i = 0; i < len; i++){
            palindrome[i][i] = true;
            longestLen = 1;
        }
        // palindrome[i][i+1] is true iff letters at i, i+1 are the same
        for (int j = 0; j < len-1; j++){
            if (s.charAt(j) == s.charAt(j+1)){
                palindrome[j][j+1] = true;
                longestLen = 2;
                longestStart = j;
                
            }
        }
        // for substrings len >= 3
        for (int k = 3; k <= len; k++){
            // for every starting index
            for (int start = 0; start < len-k+1; start++){
                int end = start + k-1;
                // if s[start, end] is palindrome, set to true
                // we need to check if s[start+1, end-1] 
                if (palindrome[start+1][end-1]){
                    if (s.charAt(start) == s.charAt(end)){
                        palindrome[start][end] = true;
                        if (k > longestLen){
                            longestLen = k;
                            longestStart = start;
                        }
                    }
                }
            }
        }
        return(s.substring(longestStart, longestStart+longestLen));
    }
}