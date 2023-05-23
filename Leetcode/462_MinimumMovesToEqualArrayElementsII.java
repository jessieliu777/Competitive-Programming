class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int median = nums[nums.length/2];
        for (int num : nums) result += Math.abs(num - median);
        return result;
    }
}