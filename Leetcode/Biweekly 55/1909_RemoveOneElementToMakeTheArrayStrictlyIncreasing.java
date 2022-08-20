class Solution {
    public boolean isIncreasing(int[] nums, int i, int max){
        int max2 = max;
                for (int j = i+1; j < nums.length; j++){
                    if (nums[j] <= max2){
                        return false;
                        
                    } else {
                        max2 = nums[j];
                    }
                }
        return true;
    }
    public boolean canBeIncreasing(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i] <= max){
                if (i == nums.length-1){
                    return true;
                } else {
                    boolean result = isIncreasing(nums, i, max);
                    if (!result && i-2 >=0){
                        result = isIncreasing(nums, i-1, nums[i-2]);
                    }
                    if (!result && i == 1 && nums.length>=3){
                        result = isIncreasing(nums, i, nums[i]);
                    }
                    
                    return result;
                }
                
            } else {
                max = nums[i];
            }
        }
        return true;
    }
}