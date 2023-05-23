class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, dp[][] = new int[m + 1][n + 1];
        // dp[i][j] = number of uncrossed lines from 0, 0 to i, j
        for (int i = 1; i <= m; ++i) for (int j = 1; j <= n; ++j)
            if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
            else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
        return dp[m][n];
    }
}