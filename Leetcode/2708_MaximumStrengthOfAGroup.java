class Solution {
    public long maxStrength(int[] nums) {
        long prod = 1; // let prod be the nonzero product
        int largestNegative = Integer.MIN_VALUE, largest = Integer.MIN_VALUE, negCount = 0;
        for(int n: nums){
            // if nonzero add it to products
            if (n != 0) prod *= n;
            // if negative update largest negative and negative count
            if(n < 0 ) { 
                largestNegative = Math.max(largestNegative, n); 
                negCount++; 
            }
            // always update largest
            largest = Math.max(largest, n);
        }
        // if largest num is 0 and neg count is at most 1, then taking the possible single negative is worse than 0, so return 0
        if(largest == 0 && negCount < 2) return 0;
        // otherwise if there's exactly one negative then return that number
        else if(largest < 0 && negCount == 1) return largestNegative;
        // otherwise if nonzero product is already positive, then no need to change anything else, just return it
        else if(prod > 0 ) return prod;
        // otherwise nonzero product must be negative, so divide it by the 'largest' negative (the negative with smallest magnitude)
        else return prod/largestNegative;
    }
}