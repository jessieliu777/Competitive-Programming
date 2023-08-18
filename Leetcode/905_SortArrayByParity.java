class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int nextEvenIndex = 0, j = 0; j < nums.length; j++)
            if (nums[j] % 2 == 0) {
                int cur = nums[nextEvenIndex];
                nums[nextEvenIndex++] = nums[j];
                nums[j] = cur;
            }
        return nums;
    }
}