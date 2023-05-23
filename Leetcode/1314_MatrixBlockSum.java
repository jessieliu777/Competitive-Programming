class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int len = mat.length, width = mat[0].length;
        int[][] sum = new int[len + 1][width + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        // let a box be 1x1, so the first box is (0, 0, 1, 1), so start with r, c = 1
        // this makes our sum arr start at 1, 1 while the given mat starts at 0, 0
        for (int r = 1; r <= len; r++) for (int c = 1; c <= width; c++) 
            sum[r][c] = mat[r - 1][c - 1] + sum[r - 1][c] + sum[r][c - 1] - sum[r - 1][c - 1]; // sum[r-1][c-1] gets added twice since sum[r-1][c] includes that sum and so doe sum[r][c-1] so deduct it
            
        int[][] ans = new int[len][width];
        for (int r = 0; r < len; r++) 
            for (int c = 0; c < width; c++) {
                int r1 = Math.max(0, r - k), c1 = Math.max(0, c - k);
                int r2 = Math.min(len - 1, r + k), c2 = Math.min(width - 1, c + k);
                r1++; c1++; r2++; c2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
                // sum of r1, c1, r2, c2 is sum(0, 0, r2, c2) - sum(0, 0, r2, c1-1) - sum(0, 0, r1-1, c2) + double deducted overlaps (=sum(0, 0, r1-1, c1-1)). 
                ans[r][c] = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
            }
        return ans;
    }
}