class Solution {
    public void rotate(int[][] matrix) {
        // reverse matrix
        Collections.reverse(Arrays.asList(matrix));
        // swap row and column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}