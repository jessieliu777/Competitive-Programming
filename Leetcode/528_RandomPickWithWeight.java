class Solution {
    Random random;
    int[] wSums;
    public Solution(int[] w) {
        this.random = new Random();
        // the code below is same as 
        // for(int i=1; i<w.length; ++i)
        //     w[i] += w[i-1];
        // this.wSums = w;
        wSums = w.clone();
        // wSums[i] = sum of w[:i] inclusive
        Arrays.parallelPrefix(wSums, Integer::sum);
    }
    
    public int pickIndex() {
        // Use accumulated freq array to get idx.
        // w[] = {2,5,3,4} => wsum[] = {2,7,10,14}
        // then get random val random.nextInt(14)+1, idx is in range [1,14]

        // idx in [1,2] return 0
        // idx in [3,7] return 1
        // idx in [8,10] return 2
        // idx in [11,14] return 3
        // then become LeetCode 35. Search Insert Position
        // Time: O(n) to init, O(logn) for one pick
        // Space: O(n)

        int len = wSums.length;
        // gets a random weight from total weight. since wSums is prefix weight, wSums[len-1] is total weight
        int randomWeight = random.nextInt(wSums[len-1]) + 1;

        // Arrays.binarySearch() returns the index of the element if it's in the array or ( -(insertion point) - 1). Insertion point is the point where the key (i.e idx) would be inserted in the array and it's either the index of the first element greater than the key or the array length if the key is greater than all the array elements.

        // For example using the array [1,3,6] and idx of 4. Arrays.binarySearch() will return (-(2)-1) = -3
        // 2 is the index of 6 which is the first element greater than 4. So to return the index we need (i.e index of 6) we did -(-3) -1 = 2
        
        // find the 'position' of the random weight in the wSums. The index of its potential position is the number that gets picked
        int i = Arrays.binarySearch(wSums, randomWeight);
        return i >= 0 ? i : ~i; // ~i equivalent to -i-1
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */