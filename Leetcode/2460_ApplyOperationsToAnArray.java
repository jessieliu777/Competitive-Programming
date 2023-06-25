class Solution {
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public int[] applyOperations(int[] nums) {
        // let i go thru every num, j go thru every index already 'swapped' by a nonzero value
        for (int i = 0, j = 0; i < nums.length; ++i){
            // if the last 2 numbers is within range, and if nums[i] == nums[i+1], then do the operation
            if (i + 1 < nums.length && nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            if (nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }   
        return nums;
    }
}