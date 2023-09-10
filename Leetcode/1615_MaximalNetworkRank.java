class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n]; // connected[i][j] = true iff i, j shares edge
        int[] neighboursCount = new int[n];
        for (int[] road : roads) {
            neighboursCount[road[0]]++;
            neighboursCount[road[1]]++;
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
        }
        int res = 0;
        // for each i, j pair of vertices
        for (int i = 0; i < n; i++) 
            for (int j = i + 1; j < n; j++) 
                // get their rank which is sum of degrees, and don't count the potential edge from i, j twice', then update max rank if necessary
                res = Math.max(res, neighboursCount[i] + neighboursCount[j] - (connected[i][j] ? 1 : 0));
        return res;
    }
}