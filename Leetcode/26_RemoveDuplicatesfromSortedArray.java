class Solution {
    public int removeDuplicates(int[] nums) {
        int pre = nums[0];
        int nextUniqueIndex = 1;
        int k = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != pre){
                nums[nextUniqueIndex] = nums[i];
                pre = nums[i];
                k++;
                nextUniqueIndex++;
            }
        }
        return k;
    }
}