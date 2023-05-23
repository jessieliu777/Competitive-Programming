class Solution {
    int count, sideLen;
    int[] f;

    public int find(int x) {
        //path compression
        if (x != f[x]) f[x] = find(f[x]); 
        return f[x];
    }

    // merge two polygons to a bigger polygon will decrease number of polygons by 1
    public void union(int x, int y) {     
        x = find(x); y = find(y);
        if (x != y) {
            f[x] = y;
            count--;
        }
    }
    // find the corresponding 1D position for current triangle. For 2D the formula is x * [y axis size] + y. For 3D it's [1D index from 2D] * [z axis size] + z => (x * sizeLen + y) * 4 + z
    public int g(int i, int j, int k) {    
        return (i * sideLen + j) * 4 + k;
    }

    public int regionsBySlashes(String[] grid) {
        // for each cell split into 4 triangles by drawing 2 diagonals
        // for each triangle in a cell, let their indices be 0: top, 1: right, 2: bottom, 3: left
        sideLen = grid.length;
        int cellCount = sideLen * sideLen; // total count of non-splitted cells is just the grid size which is sideLen * sideLen
        int cellCountSplited = cellCount * 4; // total count of triangles after splitting each cell into 4
        f = new int[cellCountSplited];  // build an array to store all parents of all triangles
        count = cellCountSplited; // in the worst case, total num of polygons is total number of splitted cells
        // initialize all the parent of each splitted cell to be itself
        for (int i = 0; i < cellCountSplited; i++) f[i] = i;

        // for every non-splitted cell
        for (int i = 0; i < sideLen; i++) {
            for (int j = 0; j < sideLen; j++) {
                // merge triangle 2 (bottom triangle) from top cell (if exists => if cur row is greater than 0) and triangle 0 (top triangle) from this cell as they were always supposed to be contiguous (given no horizontal/vertical edges except perimeter)
                if (i > 0) union(g(i - 1, j, 2), g(i, j, 0));   
                // merge triangle 1 (right triangle) from left cell (if exists => if cur col is greater than 0) and triangle 2 (right triangle) from this cell as they were always supposed to be contiguous (given no horizontal/vertical edges except perimeter)
                if (j > 0) union(g(i , j - 1, 1), g(i , j, 3));

                // if it is "\\" or empty, then we can merge top & right triangle, and also can merge bottom & left triangle
                if (grid[i].charAt(j) != '/') { 
                    union(g(i , j, 0), g(i , j,  1));
                    union(g(i , j, 2), g(i , j,  3));
                }
                // if it is "/" or empty, then we can merge top & left triangle, and also can merge bottom & right triangle
                if (grid[i].charAt(j) != '\\') { 
                    union(g(i , j, 0), g(i , j,  3)); 
                    union(g(i , j, 2), g(i , j,  1));
                }
                // These two if statements above solve the repetition issue caused by traditional three if statements
            }
        }
        return count; //return number of polygons in the graph
    }
}