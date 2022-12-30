class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // count [i] = the number of times i is in nums
        int[] res = new int[nums.length];
        
        for (int i =0; i < nums.length; i++) count[nums[i]]++;
        // for each count[i] add in count[i-1] since the number of times i-1 is in num = theres i-1 numbers less than i
        for (int i = 1 ; i <= 100; i++) count[i] += count[i-1];    

        for (int i = 0; i < nums.length; i++) {
            // if the number is 0 then no numbers are smaller than it
            if (nums[i] == 0) res[i] = 0;
            // for all other nums, some number is smaller than it, so count everything where the value is smaller than num
            // which is count[num-1]
            else res[i] = count[nums[i] - 1];
        }
        
        return res;  
    }
}