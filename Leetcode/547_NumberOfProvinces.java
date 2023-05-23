class Solution {
    int[][] isConnected;
    
    public void dfs(int i) {
        if (isConnected[i][i] == 0) return;
        for (int j = 0; j < isConnected.length; j++) {
            // 'disconnect' to mark as visited
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = isConnected[j][i] = 0;
                dfs(j);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        this.isConnected = isConnected;
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            // if it's connected, increment count and 'disconnect' (mark as visited) all the cities in this province so they don't get double counted
            if (isConnected[i][i] == 1) {
                dfs(i);
                count++;
            }
        }
        return count;
    }
}