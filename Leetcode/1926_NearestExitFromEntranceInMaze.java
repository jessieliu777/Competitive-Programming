class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+'; // set the entrance to be a wall since we can't go through it

        int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;
            int n = queue.size();
            // Check every node at the current step.
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();
                // For each node, check every direction.
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];
                    // Check if this direction out of bound.
                    if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                    // Check if this direction is the wall.
                    if (maze[x][y] == '+') continue;
                    // If this direction is empty, not visited and is at the boundary, we have arrived at the exit.
                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) return steps;
                    maze[x][y] = '+'; // set to wall means visited since we can't go back to it
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}