class Solution {
    public void setZeroes(int[][] matrix) {
        // use the first cell of every row and column as a flag. This flag would determine whether a row or column has been set to zero. This means for every cell instead of going to M+N cells and setting it to zero we just set the flag in two cells.
            
        // The first cell of row and column for the first row and first column is the same i.e. cell[0][0]. Hence, we need an additional variable to tell us if the first column had been marked or not and the cell[0][0] would be used to tell the same for the first row. 
        
        // Use 2 variables just for clarity
        boolean firstCol = false;
        boolean firstRow = false;
        
        // if any elements in the row is a 0 then the first row needs to be reset
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        
        // if any elements in the col is a 0 then the first col needs to be reset
        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        
        // If an element is zero, we set the first element of the corresponding row and column to 0
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        // Iterate over the array once again and using the first row and first column, update the elements.
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[i].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        // See if the first row, col needs to be set to zero as well
        if(firstCol){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(firstRow){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}