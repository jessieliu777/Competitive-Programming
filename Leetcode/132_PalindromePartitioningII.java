class Solution {
    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if (s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len+1]; // dp[i] is num of min cut at substr starting at index i
        for (int i = len-1; i >= 0; i--){
            int minCuts = len;
            for (int j = i; j < len; j++){
                // if s[i:j] is palindrome update mincuts
                if (isPalindrome(s, i, j)){
                    minCuts = Math.min(minCuts, dp[j+1]+1);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0]-1;
    }
}