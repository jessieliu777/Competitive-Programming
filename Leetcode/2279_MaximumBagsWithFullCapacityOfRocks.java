class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<n;i++){
            int diff = capacity[i] - rocks[i];
            if(diff == 0) count++;
            else pq.add(diff);
        }
        
        while(pq.size() > 0 && additionalRocks > 0){
            int val = pq.remove();
            if(additionalRocks >= val){
                count++;
                additionalRocks -= val;
            }
        }
        return count;
    }
}