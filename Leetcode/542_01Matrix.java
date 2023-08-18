class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0};
    public int[][] updateMatrix(int[][] mat) {
        int len = mat.length, width = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < len; ++r)
            for (int c = 0; c < width; ++c)
                // all the 0 cells have distance 0 so we are done
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                // other non 0 cells aren't done
                else mat[r][c] = -1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int newRow = r + DIR[i], newCol = c + DIR[i+1];
                if (newRow < 0 || newRow == len || newCol < 0 || newCol == width || mat[newRow][newCol] != -1) continue;
                mat[newRow][newCol] = mat[r][c] + 1;
                q.offer(new int[]{newRow, newCol});
            }
        }
        return mat;
    }
}