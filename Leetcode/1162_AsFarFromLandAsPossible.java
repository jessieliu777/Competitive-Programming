class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length, m = grid[0].length, res = 0;
        // for every grid, start with the left top corner, keep updating the distance from left top to right bottom
        // [1, 0, 0]      [1, 2, 3]
        // [0, 0, 0]  ->  [2, 3, 4]
        // [0, 0, 1]      [3, 4, 1]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201; // given n <= 100 => n+n <= 200 => n+n < 201 => max manhattan distance = max len + max height = n + n < 201
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
            }
        }
        // [1, 2, 3]    [1, 2, 3]  real distance [0, 1, 2]
        // [2, 3, 4] -> [2, 3, 2]        ->      [1, 2, 1]
        // [3, 4, 1]    [3, 2, 1]        -1      [2, 1, 0]
        for (int i = n-1; i > -1; i--) {
            for (int j = m-1; j > -1; j--) {
                if (grid[i][j] == 1) continue;
                if (i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
                if (j < m-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
                res = Math.max(res, grid[i][j]);
            }
        }
        
        return res == 201 ? -1 : res - 1;
    }
}