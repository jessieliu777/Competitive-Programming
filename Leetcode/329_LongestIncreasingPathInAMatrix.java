class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] memo;
    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        this.matrix = matrix;
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(i, j, m, n);
                max = Math.max(max, len);
            }
        }   
        return max;
    }

    public int dfs(int i, int j, int m, int n) {
        if(memo[i][j] != 0) return memo[i][j];
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            // skip out of bounds
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            // max len of cur path is 1 (cir item) + max len of neighbour path excluding cur
            int len = 1 + dfs(x, y, m, n);
            max = Math.max(max, len);
        }
        memo[i][j] = max;
        return max;
    }
}