class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];
        
        if (board[row][col] == 'M') board[row][col] = 'X';
        else {
            int mineCount = 0;
            // go through all the neighbours of cur cell
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    // skip cur cell
                    if (i == 0 && j == 0) continue;
                    // get the neighbour cell
                    int r = row + i, c = col + j;
                    // skip out of bounds
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') mineCount++;
                }
            }
            
            // If it is not a 'B' (<=> if cell has at least 1 mine in the neighbours), stop further DFS, also show the number of mines
            if (mineCount > 0) board[row][col] = (char)(mineCount + '0');
            // else Continue DFS to adjacent cells.
            else {
                //  mark cur cell as B, go through all the neighbours
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        // skip cur cell
                        if (i == 0 && j == 0) continue;
                        // get the neighbour cell
                        int r = row + i, c = col + j;
                        // skip out of bounds
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        // if neighbour is unrevealed then update board
                        if (board[r][c] == 'E') updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }
        
        return board;
    }
}