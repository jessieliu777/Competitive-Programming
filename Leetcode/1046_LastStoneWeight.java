class Solution {
    public int lastStoneWeight(int[] stones) {
        // priority queue, max first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones){
            pq.add(stone);
        }
        while (pq.size() > 1){
            int max1 = pq.remove();
            int max2 = pq.remove();
            if (max1 > max2){
                pq.add(max1-max2);
            }
        }
        int result = 0;
        if (!pq.isEmpty()){
            result = pq.remove();
        }
        return result;
    }
}