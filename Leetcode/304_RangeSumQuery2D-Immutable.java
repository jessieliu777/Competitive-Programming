class NumMatrix {
    // Construct a 2D array sums[row+1][col+1]
    // (notice: we add additional blank row sums[0][col+1]={0} and blank column sums[row+1][0]={0} to remove the edge case checking), so, we can have the following definition
    // sums[i+1][j+1] = the sum of area from matrix[0][0] to matrix[i][j]

    // To calculate sums, the ideas as below
    // +-----+-+-------+     +--------+-----+     +-----+---------+     +-----+--------+
    // |     | |       |     |        |     |     |     |         |     |     |        |
    // |     | |       |     |        |     |     |     |         |     |     |        |
    // +-----+-+       |     +--------+     |     |     |         |     +-----+        |
    // |     | |       |  =  |              |  +  |     |         |  -  |              |
    // +-----+-+       |     |              |     +-----+         |     |              |
    // |               |     |              |     |               |     |              |
    // |               |     |              |     |               |     |              |
    // +---------------+     +--------------+     +---------------+     +--------------+
    // sums[i][j]      =    sums[i-1][j]    +     sums[i][j-1]    -   sums[i-1][j-1]   +  matrix[i-1][j-1]

    // same idea to find the specific area's sum.
    // +---------------+   +---------+----+   +---+-----------+   +---------+----+   +---+----------+
    // |               |   |         |    |   |   |           |   |         |    |   |   |          |
    // |   (r1,c1)     |   |         |    |   |   |           |   |         |    |   |   |          |
    // |   +------+    |   |         |    |   |   |           |   +---------+    |   +---+          |
    // |   |      |    | = |         |    | - |   |           | - |      (r1,c2) | + |   (r1,c1)    |
    // |   |      |    |   |         |    |   |   |           |   |              |   |              |
    // |   +------+    |   +---------+    |   +---+           |   |              |   |              |
    // |        (r2,c2)|   |       (r2,c2)|   |   (r2,c1)     |   |              |   |              |
    // +---------------+   +--------------+   +---------------+   +--------------+   +--------------+

    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements inside the rectangle [0,0,i,j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */