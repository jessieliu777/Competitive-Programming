class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int countTriplet = 0;
        // check if there's at least 2 pairs such that nums[j]-nums[i] == diff starting from every element a
        for (int a = 0; a < nums.length-1; a++){
            int b = a;
            int countPair = 0;
            for (int c = a+1; c < nums.length; c++){
                if (nums[c]-nums[b] == diff){
                    countPair++;
                    // since we found one pair we need to find another one starting at pointer c
                    b = c;
                }
            }
            if (countPair >= 2){
                countTriplet++;
            }
        }
        return countTriplet;
    }
}