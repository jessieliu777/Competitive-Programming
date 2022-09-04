class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // check for pacific and atlantic separately
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        
        // if a node can reach the ocean, then all the neighbours with higher number can do so too
        
        // the top row is true for pacific, and bottom is true for atlantic
        for (int i = 0; i < heights[0].length; i++){
            pacific[0][i] = true;
            atlantic[heights.length-1][i] = true;
            updateNeighbours(heights, pacific, 0, i);
            updateNeighbours(heights, atlantic, heights.length-1, i);
        }

        // the left col is true for pacific, and right is true for atlantic
        for (int j = 0; j < heights.length; j++){
            pacific[j][0] = true;
            atlantic[j][heights[0].length-1] = true;
            updateNeighbours(heights, pacific, j, 0);
            updateNeighbours(heights, atlantic, j, heights[0].length-1);
        }
        
        // result has to be reaching both ocean
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++){
            for (int j = 0; j < heights[0].length; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    List<Integer> cur = new ArrayList<>(2);
                    cur.add(i);
                    cur.add(j);
                    result.add(cur);
                }
            }
        }
        return result;
    }
   
    public void updateNeighbours(int[][] heights, boolean[][] ocean, int row, int col){
        // up neighbour
        if (row-1 >= 0){
            if (heights[row-1][col] >= heights[row][col] && !ocean[row-1][col]){
                ocean[row-1][col] = true;
                updateNeighbours(heights, ocean, row-1, col);
            }
        }
        // down neighbour
        if (row+1 < heights.length){
            if (heights[row+1][col] >= heights[row][col] && !ocean[row+1][col]){
                ocean[row+1][col] = true;
                updateNeighbours(heights, ocean, row+1, col);
            }
        }
        // left neighbour
        if (col-1 >= 0){
            if (heights[row][col-1] >= heights[row][col] && !ocean[row][col-1]){
                ocean[row][col-1] = true;
                updateNeighbours(heights, ocean, row, col-1);
            }
        }
        // right neighbour
        if (col+1 < heights[0].length && !ocean[row][col+1]){
            if (heights[row][col+1] >= heights[row][col]){
                ocean[row][col+1] = true;
                updateNeighbours(heights, ocean, row, col+1);
            }
        }
    }
}