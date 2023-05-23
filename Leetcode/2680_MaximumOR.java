class Solution {
    public long maximumOr(int[] nums, int k) {
        // The best plan is to double the same number k times
        // this will shift the leftmost bit to left k bits.

        // right[i] = everything to the right of nums[i] = nums[i + 1] * nums[i + 2] * ... * nums[n - 1]
        // left[i] = everything to the left of nums[i] = nums[0] * nums[1] * ... * nums[i - 1]

        // So the result for doubling nums[i] k times is
        // left[i] | nums[i] << k | right[i].

        int len = nums.length, right[] = new int[len], left = 0;
        long res = 0;

        // first pass to set up right[i]'s
        for (int i = len - 2; i >= 0; i--) right[i] = right[i + 1] | nums[i + 1];
        
        // second pass to get result, also set up left[i] every iteration. since first element has no left[i] (=0) we can do this with in the same iteration after getting result for cur iteration
        for (int i = 0; i < len; i++) {
            res = Math.max(res, left | (long) nums[i] << k | right[i]);
            left |= nums[i];
        }
        return res;
    }
}