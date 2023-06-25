class Solution {
    public int heightChecker(int[] heights) {
        // count the frequency of each height (using HashMap or int[] as the height is promised to be within range[1, 100]) 
        // and use 2 pointers to make comparison:
        
        // set up height to freq map
        int[] heightToFreq = new int[101];
        for (int height : heights) heightToFreq[height]++;
        
        int result = 0;
        int curHeight = 0;
        
        for (int i = 0; i < heights.length; i++) {
            // go to the next smallest height in heights
            while (heightToFreq[curHeight] == 0) curHeight++;
            if (curHeight != heights[i]) result++;
            heightToFreq[curHeight]--;
        }
        
        return result;
    }
}