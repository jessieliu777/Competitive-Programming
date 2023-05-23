class Solution {
    public int closedIsland(int[][] g) {
	    //count the number of closed island for every box in the grid
        int count = 0; 
        for(int i = 0;i < g.length;i++){
           for(int j = 0;j < g[0].length;j++){
                if(g[i][j] == 0) count += dfs(g,i,j);
           }
        }
        return count;
    }

    // let 1 denote closed by water, 0 denote open
    private int dfs(int[][] g,int row,int col){
        // if out of bounds then nothing happens, return 0
        if(row < 0 || row >= g.length || col < 0 || col >= g[0].length) return 0;
        
        //if we meet 1 return 1. Note when iterating through the boxes only lands goes through DFS. so when 1 is met it must've been a water box that's neighbour of some land. So this direction (the direction of water relative o the original land) is 'closed'
        if(g[row][col] == 1) return 1;
        
         g[row][col] = 1;
         int up = dfs(g,row-1,col);
         int down = dfs(g,row+1,col);
         int left = dfs(g,row,col-1);
         int right = dfs(g,row,col+1);
         // if any of the neighbours are not closed by water, then it is not an island
         return up & down & left & right; 
    }
}