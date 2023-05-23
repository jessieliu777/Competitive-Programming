class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int len = grid.length, width = grid[0].length;
        int[][] diff = new int[len][width];
        int[] rows = new int[len], cols = new int[width];
        for(int i = 0; i < len; i++) for(int j = 0; j < width; j++){
            rows[i] += grid[i][j]; //# of 1s in row
            cols[j] += grid[i][j]; //# of 1s in col
        }
        
        for(int i = 0; i < len; i++) for(int j = 0; j < width; j++){
            //zeros in rowi = length of rowi - ones in rowi
            //zeros in colj = length of colj - ones in colj
            diff[i][j] = rows[i] + cols[j] - (len - rows[i]) - (width - cols[j]);
        }
        
        return diff;
    }
}