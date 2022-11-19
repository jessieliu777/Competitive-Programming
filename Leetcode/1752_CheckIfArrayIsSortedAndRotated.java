class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean rotated = false; //found i where nums[i] <= nums[i+1]
        for(int i = 0;i<n;i++) {
            int k = (i+1) % n; // num[i+1] if i is the last element k = 0
            if(nums[i] > nums[k]) {
                if (rotated) return false;
                rotated = true;
            }    
        }
        return true;
    }
}