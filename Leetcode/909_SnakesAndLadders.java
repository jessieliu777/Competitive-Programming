class Solution {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        int boardSize = len*len;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[boardSize + 1];
        // start counting the number of moves until we've reached the very last tile or we've found out we can't reach the last tile
        for (int move = 0; !queue.isEmpty(); move++) {
            // for every tile in the queue
            for (int size = queue.size(); size > 0; size--) {
                int num = queue.poll();
                // if this spot is already visited then don't go again since we don't want to be in a loop
                if (visited[num]) continue;
                // otherwise set it to be visited
                visited[num] = true;
                // if this tile is the very last then we are done
                if (num == boardSize) return move;
                // otherwise for all possible moves (given we can move up to 6 tiles forward)
                for (int i = 1; i <= 6 && num + i <= boardSize; i++) {
                    int next = num + i; // the potential next tile
                    int value = getBoardValue(board, next); // get the shortcut of the potential next tile if there is
                    if (value > 0) next = value; // if shortcut exists and isn't snake then we can just skip the next potential tile to the tile at the end of the ladder
                    if (!visited[next]) queue.offer(next); // if next tile isn't already visited then add to queue
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int num) {
        // get the row and col values of tile with num
        int len = board.length;
        int rowMirrored = (num-1) / len;
        int row = len-1 - rowMirrored; // reverse the row index so it's not mirrored
        int colMirrored = (num-1) % len;
        int col = rowMirrored % 2 == 0 ? colMirrored : len-1 - colMirrored; // reverse the column index on every other row
        
        return board[row][col];
    }
}