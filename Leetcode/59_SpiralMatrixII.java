class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0, col = 0;
        for (int i = 1; i <= n * n;) {
            // always start with right
            while (row < n && col < n && matrix[row][col] == 0 && i <= n * n) {
                matrix[row][col] = i++;
                col++;
            }
            // next box is the down box
            col--;
            row++;
            while (row < n && col < n && matrix[row][col] == 0 && i <= n * n) {
                matrix[row][col] = i++;
                row++;
            }
            // next box is the left box
            row--;
            col--;
            while (col >= 0 && matrix[row][col] == 0 && i <= n * n) {
                matrix[row][col] = i++;
                col--;
            }
            // next box is the up box
            col++;
            row--;
            while (row >= 0 && matrix[row][col] == 0 && i <= n * n) {
                matrix[row][col] = i++;
                row--;
            }
            // next box is the right box
            row++;
            col++;
        }
        return matrix;
    }
}