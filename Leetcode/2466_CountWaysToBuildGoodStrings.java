class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[] = new int[high + 1], res = 0, mod = 1000000007;
        dp[0] = 1; // dp[i] = num of good strs with len at most i
        for (int i = 1; i <= high; ++i) {
            // if we can add 0s then add 0s str to count (dp[i]) 
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % mod;
            // if we can add s then add the 1s str to count (dp[i]) 
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % mod;
            // if i is in between low and high add to result
            if (i >= low) res = (res + dp[i]) % mod;
        }
        return res;
    }
}