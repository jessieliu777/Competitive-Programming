class Solution {
    int[][] grid;
    Integer[][][] dp;
    int lenRow;
    int lenCol;
    public int cherryPickup(int[][] grid) {
        lenRow = grid.length; 
        lenCol = grid[0].length;
        this.grid = grid;
        dp = new Integer[lenRow][lenCol][lenCol]; // Integer is nullable, int is not. It's possible for a state to have 0 so we shouldn't use 0 to rep non visited states
        // give both robots start at row 0, robot1 starts at col 0, robot2 starts at col len-1
        return dfs(0, 0, lenCol - 1);
    }
    int dfs(int curRow, int curCol1, int curCol2) {
        // make sure both robots stay within bounds
        if (curRow == lenRow || curCol1 < 0 || curCol1 >= lenCol || curCol2 < 0 && curCol2 >= lenCol) return 0; 
        // if we've reached a loop then stop
        if (dp[curRow][curCol1][curCol2] != null) return dp[curRow][curCol1][curCol2];
        int max_future_cherries = 0;
        // go through every possible next move of both robots
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int tempCol1 = curCol1 + i, tempCol2 = curCol2 + j;
                if (tempCol1 >= 0 && tempCol1 < lenCol && tempCol2 >= 0 && tempCol2 < lenCol) {
                    max_future_cherries = Math.max(max_future_cherries, dfs(curRow + 1, tempCol1, tempCol2));
                }
            }
        }
        // given when 2 robots are in the same grid only one picks cherries
        int cherries = curCol1 == curCol2 ? grid[curRow][curCol1] : grid[curRow][curCol1] + grid[curRow][curCol2];
        // add the cherries from future rounds
        return dp[curRow][curCol1][curCol2] = max_future_cherries + cherries;
    }
}