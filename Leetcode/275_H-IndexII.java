class Solution {
    public int hIndex(int[] citations) {
        // The idea is to search for the first index from the sorted array so that :
        // when citations[index] == len(citations) - index then n-h papers have atleast n-h citations each, since all the papers to RHS of index must be greater as it''s sorted (the paper at index have exactly n-h papers, the papers at RHS can only have more)
        // citations[index] >= length(citations) - index => same as above, the paper at index have at least n-h papers, so the papers at RHS can only have more
        // as we want only the first such index, this must be the correct one as any thing b4 the first isn't qualified and anything after may not be optimal
        // in this case we n-h is the h-index 
        // for example arr = [0, 1, 3, 5, 6] we know h-index = 3. citations[2] >= 5 - 2 = 3
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) return len - med; 
            else if (citations[med] < len - med) lo = med + 1;
            //(citations[med] > len-med), med qualified as a hIndex,
            // but we have to continue to search for a higher one (lower med -> higher len - med)
            else hi = med - 1;
        }
        return len - lo;
    }
}