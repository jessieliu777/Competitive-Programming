class Solution {
    public int equalPairs(int[][] grid) {
        int pair=0;
        int row=0;

        while(row <= grid.length-1)
        {
            HashMap<Integer,Integer> map=new HashMap<>(); // map col to the value of cur row
            for(int col=0; col < grid.length; col++) map.put(col, grid[row][col]);
            
            // for every col
            for(int j=0; j<grid.length; j++) {
                int curr=1;
                // if any row of the col doesn't match the mapped value at the row then it's not equal to the row
                for(int i=0; i<grid.length; i++) {
                    if (map.get(i) != grid[i][j]) {
                        curr=0;
                        break;
                    }
                }
                pair += curr;
            }
            row++;
        }
        return pair;
    }
}