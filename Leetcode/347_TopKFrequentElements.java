class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // map nums to frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        // create priority queue (use it as max heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->b[0]-a[0]);
        for (int key: map.keySet()){
            int[] temp = new int[] {map.get(key), key};
            pq.add(temp);
        }
        int[] result = new int[k];
        while (--k >= 0){
            result[k] = pq.remove()[1];
        }
        return result;
    }
}