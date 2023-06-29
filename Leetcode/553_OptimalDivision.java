class Solution {
    public String optimalDivision(int[] nums) {
        // supposed a/b/c.../n got reduced to 1 fraction x/y via brackets
        // want to increase x and reduce y as much as possible
        // given a is first so it has to be the numerator. 
        // given all nums >= 2, x/y < y for all x, y
        // => (b/c/d/..../n) < (c/d/.../n) < ... n
        // => so to minimize denominator we put all the non first terms on denominator
        // can we maximize numerator by dropping any other terms out of denominator? given a has to be first and all nums >= 2, for all x, a/x < a, so leaving a as the single numerator is maximal numerator. 
        // given a is maximal numerator and (b/c/d/..../n) minimal denominator, a/(b/c/d/..../n) is maximal
        
        StringBuilder ret = new StringBuilder();
        if (nums.length == 1) ret.append(Integer.toString(nums[0]));

        else if (nums.length == 2) ret.append(Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]));
        
        else {
            ret.append(Integer.toString(nums[0]) + "/(" + Integer.toString(nums[1]));
            for (int i=2; i<nums.length; i++) ret.append("/" + Integer.toString(nums[i]));
            ret.append(")");
        }
        return ret.toString();
    }
}