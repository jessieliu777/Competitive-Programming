class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = 0;
        int minNum = Integer.MAX_VALUE;
            
        for(int element : nums){
            minNum = Math.min(element, minNum);
            maxDiff = Math.max(element-minNum ,maxDiff);
        }
        if(maxDiff == 0) return -1;

        return maxDiff;
    }
}