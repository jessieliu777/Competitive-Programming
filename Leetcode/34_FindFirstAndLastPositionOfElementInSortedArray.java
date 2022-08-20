class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0){
            return new int[]{-1, -1};
        } else if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0, 0};
            }
        } 
        // get the middle int
        int middle = nums.length/2;
        if (nums[middle] < target){
            int[] result = searchRange(Arrays.copyOfRange(nums, middle+1, nums.length), target);
            if (result[0] != -1 && result[1] != -1){
                return new int[] {result[0]+ middle+1, result[1]+middle+1};
            }
            else {
                return result;
            }
        }

        else if (nums[middle] > target){
            return searchRange(Arrays.copyOfRange(nums, 0, middle), target);
        }
        else {
            int start = searchRange(Arrays.copyOfRange(nums, 0, middle), target)[0];
            if (start == -1){
                start = middle;
            } 
            int end = searchRange(Arrays.copyOfRange(nums, middle+1, nums.length), target)[1];
            if (end == -1){
                end = middle;
            } else {
                end += middle+1;
            }
            return new int [] {start, end};
        }
        
    }
}