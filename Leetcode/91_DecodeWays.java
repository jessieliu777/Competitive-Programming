class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0; // leading 0 isn't possible to decode. For example 01 isn't a code.
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i)); // i-1st char
            int second = Integer.valueOf(s.substring(i - 2, i)); // s[i-2, i-1] inclusive
            // if we can decode the last char as a single char then + the number of ways to decode without the single char which is dp[i-1]
            if (first >= 1 && first <= 9) dp[i] += dp[i-1];
            // if we can decode the last char along with the one before that as 2 digits then + the number of ways to decode without the last 2 digits which is dp[i-2]
            if (second >= 10 && second <= 26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}