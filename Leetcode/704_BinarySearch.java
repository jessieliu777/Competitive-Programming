class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int index = left+(right-left)/2;
            // if it's smaller than target, then look right
            if (nums[index] < target){
                left = index+1;
            } else if (nums[index] > target){
                right = index-1;
            } else {
                return index;
            }
        }
        return -1;
    }
}