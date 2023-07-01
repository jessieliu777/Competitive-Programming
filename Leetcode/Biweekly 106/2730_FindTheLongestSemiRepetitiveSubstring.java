class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        // dp[i] = longest semi rep that ends at i. neg denotes already have a rep
        int len = s.length();
        int[] dp = new int[len];
        int latestRep = -1;
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                if (dp[i-1] >= 0) dp[i] = dp[i-1] + 1;
                else dp[i] = dp[i-1] - 1;
            } else {
                if (dp[i-1] >= 0) dp[i] = -(dp[i-1] + 1);
                else {
                    dp[i] = -(i - latestRep + 1);
                }
                latestRep = i;
            }
            result = Math.max(result, Math.abs(dp[i]));
        }
        return result;
    }
}