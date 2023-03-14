class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        // Change two biggest,
        // then the high score is A[n-3] - A[0]

        // Change the biggest and the smallest,
        // then the high score is A[n-2] - A[1]

        // Change two smallest,
        // then the high score is A[n-1] - A[2]

        // For the low score,
        // we can always have 2 same numbers,
        // so low score is 0.
        
        // given nums have at least 3 nums, so nothing we need to check would be out of bounds
        int len = nums.length;
        return Math.min(Math.min(nums[len - 1] - nums[2], nums[len - 3] - nums[0]), nums[len - 2] - nums[1]);
    }
}