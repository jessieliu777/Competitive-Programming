class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 3 positive -> 3 largest (+)
        // 2 positive + 1 negative -> result negative -> 1 largest (smallest abs value negative) (+) 2 smallest (smallest abs value positive) (-)
        // 1 positive + 2 negative -> result positive -> 1 largest (+) 2 smallest (largest abs value negative) (-)
        // 3 negative -> result negative -> 3 largest (smallest abs value negative)(-)
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }
}