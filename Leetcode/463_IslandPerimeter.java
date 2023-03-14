class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }
        // Each grid has 4 edges => total number of edges = number of islands * 4
        // When 2 grids are connected they share an edge, so don't count the shared edge. We can do that by deducting the edge from one of them. Since there is 4 directions up, right, down, left, there's 2 axis vertical, horizontal then we only need to check one direction for each axis. TWLOG pick right and down to be the 2 directions of each axis to count.
        return islands * 4 - neighbours * 2;
    }
}