class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        // split the array in to part from the point where the two consicutive elemnts have min difference. So the lower side array have max value and the next element is the min of the next upper side array section.
        for (int i=1; i<nums.length; i++) min=Math.min(min, nums[i]-nums[i-1]);
        return min;
    }
}