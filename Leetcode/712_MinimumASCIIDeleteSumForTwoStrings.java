class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        // We will create a 2D matrix with n+1 and m+1 size and will initialize first row and first column using s1 and s2.
        // So this 0th row/column repesents an empty string(""), let's take an example.

        // case 1:
        // s1="" and s2="e", then we just have to delete e to make both string equal, so our result will be 101.
        // case 2:
        // s1="" and s2="ea", then we'll have to delete both "e" and "a" , so our result will be 101+97 => 198.
        // and in the similar way,
        // if s1="s" and s2="", then we will have to delete "s", so our output will be 115.
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1]; //dp[i][j] = min delete sum of s1[:i] and s2[:j] inclusive

        //initialize first column with prefix sum of s1 values, and first row with prefix sum of s2 values
        for(int i=1; i<=len1; i++) dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        for(int i=1; i<=len2; i++)  dp[0][i] = dp[0][i-1] + s2.charAt(i-1);
        
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
				// if both characters are equal then use previous diagonal value
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j] + s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
            }
        }
        return dp[len1][len2];
    }
}