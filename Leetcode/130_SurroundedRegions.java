class Solution {
    /**
    if board[r][c] is in bounds and is O then mark it as visited, also do the same for its adjacent O's
    */
    private void DFS(char[][] board,int r,int c,int rsize,int csize){
        // if row r, col c out of bounds or if board[r][c] is not O then we are done
        if(r<0||c<0||r==rsize||c==csize||board[r][c]!='O')return;
        // otherwise set a placeholder to denote that denote we've already visited this O
        board[r][c] = 'V';
        // do the same for all this cell's neighbours'
        DFS(board,r+1,c,rsize,csize);
        DFS(board,r,c+1,rsize,csize);
        DFS(board,r-1,c,rsize,csize);
        DFS(board,r,c-1,rsize,csize);
    } 
    public void solve(char[][] board) {
        if(board.length==0) return;
        int row = board.length, col = board[0].length;
        // get the O's connected to first row and last row (top & bottom border)
        // then mark them as visited V
        for(int i=0;i<col;i++){
            DFS(board,0,i,row,col);//for FIRST ROW
            DFS(board,row-1,i,row,col);//for LAST ROW
        }
        // do the same for first col, last col (left & right border)
        for(int i=0;i<row;i++){
            DFS(board,i,0,row,col);//for FIRST COLUMN
            DFS(board,i,col-1,row,col);//for LAST COLUMN
        }
        // now all the O's connected to the border have been marked as V, so the remaining O's must be not connected to border
        // for every cell, if it's O then it's not connected to the border so we should capture (convert to X)
        // otherwise if it's V (converted O cuz it s connected to border) then don't capture (change it back to O)
        for(int i=0;i<row;i++) for(int j=0;j<col;j++) 
            if(board[i][j]=='O')board[i][j]='X';
            else if(board[i][j]=='V')board[i][j]='O';
    }
}