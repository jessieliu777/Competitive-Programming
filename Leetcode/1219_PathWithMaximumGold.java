class Solution {
	private int rows, cols;
	int[] DIR = new int[]{0, 1, 0, -1, 0};
	int[][] grid;

    public int getMaximumGold(int[][] grid) {
        rows = grid.length;
		cols = grid[0].length;
		this.grid = grid;
        int maxGold = 0;
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                maxGold = Math.max(maxGold, findMaxGold(r, c));
        return maxGold;
    }

	/**
	given r, c is the origin, find the max gold path value
	 */
    int findMaxGold(int r, int c) {
		// stop when out of bounds
        if (r < 0 || r == rows || c < 0 || c == cols || grid[r][c] == 0) return 0;
        int origin = grid[r][c];

        grid[r][c] = 0; // mark as visited
        int maxGold = 0;
		// go through all the neighbours, find the max gold of them
        for (int i = 0; i < 4; i++) maxGold = Math.max(maxGold, findMaxGold(DIR[i] + r, DIR[i+1] + c));
        grid[r][c] = origin; // unmark as visited to be able to visit r, c via different origin in future iterations
		// for cur result, the max gold with r, c origin is the value at r, c + the max gold of its neighbours path
        return maxGold + origin;
    }
}