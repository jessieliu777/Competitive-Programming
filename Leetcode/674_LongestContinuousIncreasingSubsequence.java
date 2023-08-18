class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 1, curLen = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[i-1] < nums[i]) maxLen = Math.max(maxLen, ++curLen);
            else curLen = 1;
        }
        return maxLen;
    }
}