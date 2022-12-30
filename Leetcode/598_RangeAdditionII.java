class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int min_row = m;
        int min_col = n;
        for (int i=0; i<ops.length; i++){
            min_row = Math.min(min_row, ops[i][0]);
            min_col = Math.min(min_col, ops[i][1]);
        }        
        return min_row*min_col;
    }
}