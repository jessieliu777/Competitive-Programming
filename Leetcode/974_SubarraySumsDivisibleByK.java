class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // for an array int[] A, where N = len(A), that there are N prefix sums.
        // prefix[0] = A[0], prefix[1] = A[0] + A[1], ... prefix[i] = A[0] + ... + A[i].

        // Then to calculate how many subarrays are divisible by K is logically equivalent to saying, how many ways can we pair up all prefix sum pairs (i,j) where i < j
        // such that (prefix[j] - prefix[i]) % K == 0.

        // Just from that information alone we easily get a O(n^2) solution:
        // Compute all prefix sums, then check all pair to see if k divides the difference between them.

        // However, if we just exploit some information wrt to the remainder of each prefix sum we can manipulate this into a linear algorithm.

        //There k mod groups 0...K-1
        //For each prefix sum that does not have remainder 0 it needs to be paired with 1 with the same remainder
        //this is so the remainders cancel out.
        int len = nums.length;
        int[] modGroupSums = new int[k]; // modGroupSums[i] = sum of mod group i
        int sum = 0;
        // for every num
        for (int i = 0; i < len; i++){
            sum += nums[i]; // add it to the sum
            int modGroup = sum % k; // get the prefix sum of num's mod group
            if (modGroup < 0) modGroup += k; //Java has negative modulus so correct it
            modGroupSums[modGroup]++; // increment the sum of this mod group
        }
        int total = 0;

        // N(N-1) / 2 = (N Choose 2) = Unique possible Pairs = Each prefix sum represents a possible start and end of a possible interval. 
        // If there are N different prefix sums that have a certain reaminder, then you can uniquely pair them up in N choose 2 ways (n(n-1) / 2)
        
        // in our case each modGroup (index) in modGroupSums have modGroupSums[modGroup] (value) diff prefix sums as calculated above 
        // => we can uniquely pair up each of the modGroupSums[modGroup] in modGroupSums[modGroup] choose 2 ways = modGroupSums[modGroup] * (modGroupSums[modGroup]-1)/2 ways
        // for every mod group sum i we need to find j st (i-j) % k == 0 iff j % k = i % k
        for (int modGroupSum : modGroupSums) if (modGroupSum > 1) total += modGroupSum*(modGroupSum-1) / 2;
        
        // also add in prefix sum of mod group 0 since it already is divided by k (the subarr starts from first num) (basically it is mod sum group i st i % k == 0)
        return total + modGroupSums[0];
    }
}