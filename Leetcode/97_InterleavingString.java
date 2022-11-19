class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + s2.length() != len3) return false;

        boolean dp[] = new boolean[len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) 
                    dp[j] = true;
                // for first iteration, dp[j] is true if the previous col is true and s2[j-1] is s3[i+j-1] (since s3[:i] is already done)
                else if (i == 0) 
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                // for the first letter of s2 of every iteration, dp[j] is true if the dp[j] (from previous iteration) is true  and s1[i-1] is s3[i+j-1] (since s3[:j] is already done
                else if (j == 0) 
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                // for other cases, we need the current char of s3 to either be the next cur char in s1 and dp[j] from previous iteration is true or s2 and dp[j-1] from previous col is true
                else 
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                                || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[len2];
    }
}