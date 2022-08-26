class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int old = image[sr][sc];
        image[sr][sc] = color;
        if (color == old) return image;
        if (sr > 0){
            if (image[sr-1][sc] == old) floodFill(image, sr-1, sc, color);
        } 
        if (sc > 0){
            if (image[sr][sc-1] == old) floodFill(image, sr, sc-1, color);
        }
        if (sr < image.length-1){
            if (image[sr+1][sc] == old) floodFill(image, sr+1, sc, color);
        }
        if (sc < image[0].length-1){
            if (image[sr][sc+1] == old) floodFill(image, sr, sc+1, color);
        }
        return image;
    }
}