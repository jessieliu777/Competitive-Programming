class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while (start <= end) {
            int index = start + (end-start)/2;
            if (nums[index] < target){
                start = index+1;
            } else if (nums[index] > target){
                end = index-1;
            } else {
                return index;
            }
        }
        return start;
    }
}