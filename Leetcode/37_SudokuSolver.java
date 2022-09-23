class Solution {   
    boolean isValid(char[][] board , int row , int col , char val){
        for(int m = 0 ; m < 9 ; m++){
            if(board[row][m] == val) return false;
            if(board[m][col] == val) return false;
            if(board[3*(row/3) + m/3][3*(col/3) + m%3] == val) return false;
        }
        return true;
    }
    
    boolean solve(char[][] board){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    for (char num = '1'; num <= '9'; num++){
                        if (isValid(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board))return true;
                            else board[i][j]='.';
                        }
                    }
                    // if none of the 9 numbers are valid for this box, then we must been wrong with a previous box
                    return false;
                }
            }
        }
        // the board will have to be valid after we went through everything since by question there is 1 solution
        return true;
    }
    
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}