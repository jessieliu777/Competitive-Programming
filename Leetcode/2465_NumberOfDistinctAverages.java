class Solution {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length/2;i++){
            set.add(nums[i]+nums[nums.length-1-i]);
        }
        return set.size();
    }
}