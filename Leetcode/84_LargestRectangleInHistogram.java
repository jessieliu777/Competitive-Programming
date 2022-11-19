class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] lessFromLeft = new int[heights.length]; // lessFromLeft[i] = idx of the first bar the left that is lower than i
        int[] lessFromRight = new int[heights.length]; // lessFromRight[i] = idx of the first bar the right that is lower than i
        
        // there's no bar right of the rightest bar and no bar left of the leftest bar
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;

        // get the lessFromLeft for all indices
        for (int i = 1; i < heights.length; i++) {
            // default to be 1 left of i
            int p = i - 1;
            // if left is higher than current  height then get the lessFromLeft of left, keep going for all left heights higher
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        // same for right
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
        
        // get the max area
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }
}