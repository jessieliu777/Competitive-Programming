class Solution {
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        // find the decreasing element D from right to left
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            // find the element that's 1 greater than D, then swap them
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // reverse the subarray after D
        reverse(nums, i + 1);
    }
}