class Solution {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[cur] = nums[i];
                cur++;
            } else {
                k--;
            }
        }
        return k;
    }
}