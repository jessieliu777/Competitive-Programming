class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // oddRows[i] = true iff ith row got incremented odd amount of times
        boolean[] oddRows = new boolean[m], oddCols = new boolean[n];
        for(int index[] : indices)
        {
            oddRows[index[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[index[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }    
        int count = 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                // even + odd = odd + even = odd
                count += oddRows[i] ^ oddCols[j] ? 1 : 0; 
            }        
        return count;
    }
}