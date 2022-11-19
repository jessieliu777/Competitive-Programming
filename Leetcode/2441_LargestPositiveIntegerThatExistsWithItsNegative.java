class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        // two pointer, left checks for -k, right checks for k
        int right = nums.length-1;
        int left = 0;
        while (left < right){
            // if -k's magnitude is too small, then move right pointer left
            if (-nums[left] < nums[right]){
                right--;
            } 
            // if -k's magnitude is too large, then move left pointer right
            else if (-nums[left] > nums[right]){
                left++;
            } else {
                return nums[right];
            }
        }
        return -1;
    }
}