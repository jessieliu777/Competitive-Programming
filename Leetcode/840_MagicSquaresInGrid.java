class Solution {
    int[][] grid;

    // given coordinates x, y returns whether the 3x3 where the left top corner is (x, y) is a magic box or not
    public boolean isAMagicBox(int x, int y){
        // center must be 5
        if(grid[x+1][y+1]!=5) return false;
        
        // 1-9 must all be contained
        boolean[] valid = new boolean[16];
        for(int i=x; i<=x+2; i++) for(int j=y; j<=y+2; j++) valid[grid[i][j]] = true;
        for (int v = 1; v <= 9; v++) if (!valid[v]) return false;
        
        // sum of rows, cols, diags must be 15
        if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15)         return false;
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15)     return false;
        if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15)         return false;
        if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15)     return false;

        return true;
    }

    public int numMagicSquaresInside(int[][] grid) {
        this.grid = grid;
        // grid must be at least 3x3 to contain a magic square
        if(grid.length < 3 || grid[0].length < 3) return 0;
        int magicBoxCount = 0;
        for(int i=0; i<=(grid.length-3); i++) for(int j=0; j<=grid[0].length-3; j++)
            // if the 3x3 box starting at i, j left corner is a magic box then increment count
            if(isAMagicBox(i, j)) magicBoxCount++;
        return magicBoxCount;
    }
}