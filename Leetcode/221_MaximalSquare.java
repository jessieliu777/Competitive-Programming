class Solution {
    public int maximalSquare(char[][] matrix) {
      int max = 0, n = matrix.length, m = matrix[0].length;

      // dp(i, j) = max value of square lower-right corner is located at (i, j)
      // dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) } since any squares with a single 0 is 0 value
      int[][] dp = new int[n + 1][m + 1];

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          if (matrix[i - 1][j - 1] == '1') {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
            max = Math.max(max, dp[i][j]);
          }
        }
      }

      // return the area
      return max * max;
    }
}