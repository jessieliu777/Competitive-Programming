class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int maxEndingAtCur = nums[0];
        // at each index
        for (int i = 1; i < nums.length; i++){
            // check if adding the subarray til cur + cur is larger or smaller than cur
            // if cur is larger, then the maxEnding at cur is just cur, otherwise take the other option
            maxEndingAtCur = Math.max(maxEndingAtCur + nums[i], nums[i]);
            if (maxEndingAtCur > result){
                result = maxEndingAtCur;
            }
        }
        return result;
    }
}