class Solution {
    public int uniquePaths(int m, int n) {
        // dp[i][j] = unique paths from 0, 0 to [i][j]
        int[][] dp = new int[m][n];
        // first row only has 1 unique path since we can only go right
        Arrays.fill(dp[0], 1);
        // first col only has 1 unique path since we can only go down
        for (int[] row: dp){
            row[0] = 1;
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}