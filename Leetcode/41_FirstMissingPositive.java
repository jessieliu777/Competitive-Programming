class Solution {
    public int firstMissingPositive(int[] nums) {
        // add all positive values to a hashset
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                set.add(nums[i]);
            }
        }
        int missing = 1;
        while (set.contains(missing)){
            missing++;
        }
        return missing;
    }
}