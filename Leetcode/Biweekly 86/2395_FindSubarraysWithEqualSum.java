class Solution {
    public boolean findSubarrays(int[] nums) {
        // use sliding window of 2
        for (int i = 0; i < nums.length-2; i++){
            int sum1 = nums[i] + nums[i+1];
            for (int j = i+1; j < nums.length-1; j++){
                int sum2 = nums[j] + nums[j+1];
                if (sum1 == sum2) return true;
            }
        }
        return false;
    }
}