class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        
        // for every number
        for (int num : nums) {
            // if it's smaller than min the update min
            if (num <= min) min = num;
            // if it's between min and second min, then update second min
            else if (num > min && num <= secondMin) secondMin = num;
            // if it's greater than both then we have the triplet
            else return true;
        }
        
        return false;
    }
}