class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // ways to get to i, j = ways to get to i, j-1 + ways to get to i-1, j
        int[][] ways = new int [obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0] == 0){
            obstacleGrid[0][0] = 1;
        } else {
            obstacleGrid[0][0] = 0;
        }
        
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                if (! (i == 0 && j == 0)){
                    int cur = 0;
                    // if i, j not obstacle
                    if (obstacleGrid[i][j] != 1){
                        if (i != 0){
                        cur += obstacleGrid[i-1][j];
                        }
                        if (j != 0){
                            cur += obstacleGrid[i][j-1];
                        }
                    }
                    obstacleGrid[i][j] = cur;
                }
            }
        }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}