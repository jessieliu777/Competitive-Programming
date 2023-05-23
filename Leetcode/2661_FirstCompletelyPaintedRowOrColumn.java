class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>(); // map value of matrix to coordinates
        int len=mat.length;
        int width=mat[0].length;
        for (int i=0; i<len; i++) for (int j=0; j<width; j++) map.put(mat[i][j], new int[]{i, j});
            
        int rows[] = new int[len]; // rows[i] = number of painted items in row i
        int cols[] = new int[width]; // cols[i] = number of painted items in col i
        for (int i = 0; i < arr.length; i++)
        {
            int coordinates[] = map.get(arr[i]);
            rows[coordinates[0]]++;
            cols[coordinates[1]]++;
            if (rows[coordinates[0]] == width || cols[coordinates[1]] == len) return i;
        }
        return -1;
    }
}