class Solution {
    public long minimumReplacement(int[] nums) {
        int len = nums.length , prev=nums[len-1];
        long ans=0;
        for(int i=len-2; i>=0; i--){
            // if prev divides into cur (iff prev is some divisor of cur), then we can split cur into prevs * divident = prev + prev + ... (divident amount of times), so the number of divisions is divident - 1. (Base case split cur into 2 prevs. that's 1 split'). In this case since cur all becomes prev the next iteration prev = cur = prev of this iteration, so no change
            int divident = nums[i]/prev; 
            // now if prev is not a divisor, cur/pre will have some remainder.
            if((nums[i]) % prev != 0){
                // need an extra split for the remainder
			    divident++;
                // recalculate prev of next iteration using the new split count (divident) Since old divident isn't a divisor, using old divident will make new prev too small
                // for ex prev = 5, cur = 7
                // optimal is 7 = 3, 4 not 7 = 2, 5
                // orig divident is 7/5 = 1, but to caculate new prev 7/1 > 5, so increse the divident 7/2 = 3
                prev=nums[i]/divident;
            }   
            ans+=divident-1;
        }
        return ans;
    }
}