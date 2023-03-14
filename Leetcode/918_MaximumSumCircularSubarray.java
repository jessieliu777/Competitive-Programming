class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = 0, curMax = nums[0], minSum = 0, curMin = nums[0];
        for (int num: nums) {
            // maximum subarr sum is either maxSum+num (add num to prev subarr) or just num (start a new subarr)
            maxSum = Math.max(maxSum + num, num);
            // cur max value is either the cur subarr from maxSum or sum of some previous subarr that we moved on (prev curMax value)
            curMax = Math.max(maxSum, curMax);
            // same thing with min
            minSum = Math.min(minSum + num, num);
            curMin = Math.min(minSum, curMin);
            total += num;
        }
        // in the case of all negative numbers the algo would return empty subarray sum = 0 but given we need nonempty subarray we just have to use the curMax value in that case
        return curMax > 0 ? Math.max(curMax, total - curMin) : curMax;
    }
}