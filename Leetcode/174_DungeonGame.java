class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] health = new int[m][n]; // health[i][j] = opt health when player is at i, j
        // from bottom right to origin
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                // when player is at the bottom right corner the starting health must be minimaly enough to cover the potential damage
                if (i == m-1 && j == n-1) health[i][j] = Math.max(1, 1 - dungeon[i][j]);
                // when player is at right edge, the current health must be minimally enough to cover the potential damage on the current cell + potential damage at the bottom neighbor (health[i][j+1] calculated at some previous iteration)
                else if (i == m -1) health[i][j] = Math.max(1, health[i][j+1] - dungeon[i][j]);
                // similarly, when player is at bottom, the current health must minimally enough to cover the potential damage on the current cell + potential damage at the right neighbour (health[i+1][j] calculated at some previous iteration)
                else if (j == n-1) health[i][j] = Math.max(1, health[i+1][j] - dungeon[i][j]);
                // at any other cell, we know right and bottom neighbour have to exist, so take the path with minimal req of health
                else health[i][j] = Math.max(1, Math.min(health[i+1][j], health[i][j+1]) - dungeon[i][j]);
                
            }
        }
        return health[0][0];
    }
}