class Solution {
    // let 0 = dead, 1 = live. Use 2 bits to store 2 states:
    // [2nd bit, 1st bit] = [next state, current state]
    // - 00  dead (next) <- dead (current)
    // - 01  dead (next) <- live (current)  
    // - 10  live (next) <- dead (current)  
    // - 11  live (next) <- live (current) 
    // In the beginning, every cell is either 00 or 01.
    // Notice that 1st state is independent of 2nd state.
    // Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
    // Let's count # of neighbors from 1st state and set 2nd state bit.
    // Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
    // In the end, delete every cell's 1st state by doing >> 1.
    // For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

    // Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
    // Transition 00 -> 10: when board == 0 and lives == 3.
    // To get the current state, simply do
    // board[i][j] & 1

    // To get the next state, simply do
    // board[i][j] >> 1

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit (nxt state) is 0;
                // So we only need to care about when will the 2nd bit become 1.
                // if cur cell is alive, and it has between 2 to 3 alive neighbours then it will stay alive. Make the 2nd bit 1: 01 ---> 11
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) board[i][j] = 3;
                
                // if cur cell is dead and it has exactly 3 neighbours then it will revive. Make the 2nd bit 1: 00 ---> 10
                else if (board[i][j] == 0 && lives == 3) board[i][j] = 2;
            
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                // if current state of cell is alive, add it to count
                lives += board[x][y] & 1;
            }
        }
        // don't count the current cell'
        lives -= board[i][j] & 1;
        return lives;
    }
}