class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int result = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == target){
                if (Math.abs(i-start) < result || result == -1){
                    result = Math.abs(i-start);
                }
            }
        }
        return result;
    }
}