class Solution {
    public int pivotIndex(int[] nums) {
        // go through every element as if it's the pivot
        // for each pivot, calculate the sum
        int leftSum = 0;
        int rightSum = IntStream.of(nums).sum();
        for (int i = 0; i < nums.length; i++){
            rightSum -= nums[i];
            if (leftSum == rightSum){
                return (i);
            }
            leftSum += nums[i];
        }
        return -1;
        
    }
}