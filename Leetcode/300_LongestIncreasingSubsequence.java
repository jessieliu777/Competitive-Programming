class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> piles = new ArrayList<>(nums.length);
        // go through every num
        for (int num : nums) {
            // Find the index of num. If num is not present, the it returns "(-(insertion point) - 1)". 
            int pile = Collections.binarySearch(piles, num);
            // if pile < 0 then change pile to be abs(pile) -1 (insertion point = abs(-(insertion point) - 1) - 1)
            if (pile < 0) pile = ~pile;
            // if the insertion point is the pile size then current seq is increasing, so we can add num to piles
            if (pile == piles.size()) piles.add(num);
            // otherwise insertion point has to be in the piles, so replace the old one with num
            // Note we only care about the len of the LIS not the actual LIS. so even if we replace old value with num that results in a non-subseq of arr, it doesn't matter as long as the len is the same 
            else piles.set(pile, num);
            
        }
        return piles.size();
    }
}