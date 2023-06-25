class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; ++i) pairs[i] = new int[] {nums1[i], nums2[i]};
        // pair is sorted by num2 value from largest to smallest
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
        // pq is min queue of num1 that has size of k
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);

        long res = 0, sum = 0;
        // go thru each pair
        for (int[] pair : pairs) {
            // add cur num1 to pq, it also contributes to the sum of the cur subseq of size k
            pq.add(pair[0]);
            sum += pair[0];
            // if pq size is over k, then we need to remove something. to maximize sum, remove the smallest element
            // NOTE if cur num1 gets removed it still works
            // assuming it get removed then it must be the smallest in the num1 so far. The problem would be if cur num1 gets removed while cur num2 gets counted in formula. cur num2 by how pair2 was constructed have to be the smallest num2 so far. So even if this is the wrong formula it's never going to get through as it won't exceed the previous max result, so prev res still gets preserved.
            if (pq.size() > k) sum -= pq.poll();
            // if pq size is exactly k, then we have a potential subseq, update result score. since pair is sorted by nums2 desc we know cur nums2 (pair[1]) must be the smallest in the subseq
            if (pq.size() == k) res = Math.max(res, (sum * pair[1]));
        }
        return res;
    }
}