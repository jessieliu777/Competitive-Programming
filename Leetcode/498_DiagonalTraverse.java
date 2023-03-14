class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        int row = 0, col = 0, rowLen = mat.length, colLen = mat[0].length, arr[] = new int[rowLen * colLen];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = mat[row][col];
            // cur cell is going upright iff rowIndex + colIndex is even
            if ((row + col) % 2 == 0) { // moving up
                // if last col then simply increment row only. There are no more space right, so next index has to be downleft
                if (col == colLen - 1) row++;
                // if first row then increment col only. There is no more space up, so next index has to be downright
                else if (row == 0) col++;
                // otherwise there must space to goup right, so go upright
                else {
                     row--; 
                     col++; 
                }
            } 
            // cur cell is going downleft iff rowIndex + colIndex is odd
            else { 
                // same idea as even rowIndex + colIndex cells
                if (row == rowLen - 1) col++;
                else if (col == 0) row++;
                else {
                    row++; 
                    col--;
                }
            }   
        }   
        return arr;
    }
}