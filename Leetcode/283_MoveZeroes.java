class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            // move the nonzero ones to the next index
            if (nums[i] != 0){
                nums[cur] = nums[i];
                if (cur != i){
                    nums[i] = 0;
                }
                cur++;
            }
        }
    }
}