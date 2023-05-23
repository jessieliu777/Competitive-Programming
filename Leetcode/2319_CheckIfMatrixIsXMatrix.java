class Solution {
    public boolean diagonal(int i,int j,int n){
        // i == j forward diagonal, i+j+1 == n backward diagonal
        return i==j || i+j+1==n;
    }

    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(diagonal(i,j,n)){
                    if(grid[i][j]==0) return false;
                }
                else if(grid[i][j]!=0) return false;
            }
        }
        return true;
    }
}