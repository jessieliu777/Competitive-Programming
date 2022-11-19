class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        // for every cell
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target) return true;
            // if cell is too large, then decrease col
            else if(matrix[i][j] > target) j--;
            // if cell is too small, then increase row
            else if(matrix[i][j] < target) i++;
        }
        return false;
    }
}