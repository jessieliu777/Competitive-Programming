class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] maxRob = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            // the max profit is either current house + max profit up til 2 houses away or the max profit up til 1 house away 
            maxRob[i] = Math.max(nums[i] + maxRob[i-2], maxRob[i-1]);
        }
        return maxRob[nums.length-1];
    }
}