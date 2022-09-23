class Solution {
    public int minPathSum(int[][] grid) {
        // dp[i][j] = minsum from grid[0][0] to grid[i][j]
        int dp[][] = new int[grid.length][grid[0].length];
        for (int[] row : dp)
        {
            Arrays.fill(row,-1);
        }        
        dp[0][0] = grid[0][0];
        helper(grid.length-1, grid[0].length-1, grid, dp);
        return dp[grid.length-1][grid[0].length-1];
    }
    
    private void helper(int row, int col, int[][] grid, int[][] dp){
        if (dp[row][col] != -1) return;
        // if up or left neighbour exists
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(row > 0){
            if (dp[row-1][col] == -1){
                helper(row-1, col, grid, dp);
            }
            up = grid[row][col] + dp[row-1][col];
        }
        if (col > 0){
            if (dp[row][col-1] == -1){
                helper(row, col-1, grid, dp);
            }
            left = grid[row][col] + dp[row][col-1];
        }    
        dp[row][col] = Math.min(up,left);
    }
}