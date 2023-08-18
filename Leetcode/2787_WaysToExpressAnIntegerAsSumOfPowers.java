class Solution {
    public int numberOfWays(int n, int x) { 
        // dp[i] mean the ways to present i.
        // dp[i] = dp[i] + dp[i - v] where cur = root ^ x.
        int dp[] = new int[n+1],  mod = 1000000007, cur;
        dp[0] = 1; // only one way to represent 0 0^x
        // go thru every possible 'root'
        for (int root = 1; (cur = (int)Math.pow(root, x)) <= n; root++)
            // for all the numbers between n and cur inclusive, increment these by number of ways to get i-cur. 
            for (int i = n; i >= cur; i--)
                // number of ways to get i is incremented by number of ways to get cur * number of ways to get i - cur = 1 * dp[i-cur]
                dp[i] = (dp[i] + dp[i - cur]) % mod;
        return dp[n];
    }
}