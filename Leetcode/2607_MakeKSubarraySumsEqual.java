class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        // Given k, Sum of each window of size k will be same only if every window contains same numbers in them.
        // We can make sure that every window of size k contains the same elements by following below rule(Say rule 1).

        // arr[i] == arr[i + k]
        // arr[i] == arr[i + 2 * k]
        // and so on.
        // Take the example

        // Input: arr = [1,4,1,3], k = 2
        // Output: 1
        // Explanation: we can do one operation on index 1 to make its value equal to 3.
        // The array after the operation is [1,3,1,3]
        // - Subarray starts at index 0 is [1, 3], and its sum is 4 
        // - Subarray starts at index 1 is [3, 1], and its sum is 4 
        // - Subarray starts at index 2 is [1, 3], and its sum is 4 
        // - Subarray starts at index 3 is [3, 1], and its sum is 4 
        // Play around with this example. You can't defy rule 1 and achieve an working solution.

        //  Consider array 
        // [x, y, z, a, b, c]
        // Let k be 3. 
        // [x, y, z, a, b, c]
        //  |     |         - Let this Sum be A (x + y + z)
        // Now slide window
        // [x, y, z, a, b, c]
        //     |     |      - Let this Sum be B (A - x + a)
        // Here Sum of this subarray B can be equal to A only if a is equal to x. 
        // Similarly by sliding window further we know that b has to be equal to y and c has to be equal to z.
        // Which is what the rule says.

        // arr[i] == arr[i + k]
        // arr[i] == arr[i + 2 * k]
        // and so on.
        
        // As we roll a window of size k, we remove element arr[i] and add element arr[i + k].

        // For the sum to stay the same, the removed and added element must be the same. This can be also proven by a contradiction.

        // So, for each position i, we collect all elements in the k-cycle.

        // Then, we determine the median and perform operations to make all elements equal to that median.
        
        long res = 0;
        // for the ith element in the window of size k
        for (int i = 0; i < k; i++) {
            List<Integer> window = new ArrayList<>();
            // (Q462 uses the same strategy except on the whole arr instead of subarr)
            // go through the ith element in all windows
            for (int j = i; arr[j] != 0; j = (j + k) % arr.length) {
                // add the element to the cur window arr, set it to 0 to mark it as visited
                window.add(arr[j]);
                arr[j] = 0;
            }
            Collections.sort(window);
            // the median of sorted arr of n elements is arr[size/2]
            // as proved, every ith element in the window have to be the same for the subset k sum to be equal. So for every ith element of the window, aim to make it the median. The amount of operations to make a number into a median is the absolute difference
            for (int num : window) res += Math.abs(num - window.get(window.size() / 2));
        }
        return res;
    }
}