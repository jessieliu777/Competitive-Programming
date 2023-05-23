class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, min = Integer.MAX_VALUE;
        // use sliding window from start to end
        while (end < nums.length) {
            // keep trying to add numbers of end pointer to subarr sum
            sum += nums[end++];
            // once the sum is at least target, then we need to calculate the min len
            while (sum >= target) {
                min = Math.min(min, end - start);
                // move start pointer since if we keep the start pointer the len can only get longer and we dc the longer lens
                sum -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}