class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] covered = new boolean[rows][cols];
        int checked = 0;
        // count ones
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count ++;
                }
            }    
        }
            
        while (checked < count){
            int[] arr = next(grid, covered);
            if (arr != null){
                checked += cover(covered, arr[0], arr[1], grid);
                num +=1;
            }
        } 
        return num;
    }

    public int cover(boolean[][] covered, int i, int j, char[][]grid){
        int done = 0;
        if (!(i<0 || i >= grid.length || j < 0 || j >= grid[0].length)){
            if (grid[i][j] == '1'){
                if (!covered[i][j]){
                    covered[i][j] = true;
                    done++;
                    done += cover(covered, i-1, j, grid);
                    done += cover(covered, i+1, j, grid);
                    done +=cover(covered, i, j-1, grid);
                    done +=cover(covered, i, j+1, grid);
                }
            }
                
        }
        return done;
    }
                 
    public int[] next(char[][]grid, boolean[][]covered){
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    int [] arr = {i, j};
                    if (!covered[i][j]){
                        return arr;
                    }
                }
            }    
        }
        return null;
    }
        
}