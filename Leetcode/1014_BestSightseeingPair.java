class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxValue = 0, curValue = 0;
        for (int value: values) {
            maxValue = Math.max(maxValue, curValue + value);
            // when we move forward, all sightseeing spot we have seen will be 1 distance further, thus the -1
            curValue = Math.max(curValue, value) - 1; 
        }
        return maxValue;
    }
}