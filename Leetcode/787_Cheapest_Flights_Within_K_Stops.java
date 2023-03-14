class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n]; // let cost[i] = cost to get to i from src
        // initialize cost to be max value
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src]=0;
        // for every step
        for(int i=0; i<= k; i++) {
            // copy the cost arr at the beginning of every step
            int[] temp = Arrays.copyOf(cost,n);
            // for every flight ('edge')
            for(int[] flight: flights) {
                int curr=flight[0], next=flight[1], price=flight[2];
                // if the 'edge' doesn't connect to any node we've visited 
                // <=> the cost of cur isn't updated (still max value)
                // then the path is broken so skip
                if(cost[curr] == Integer.MAX_VALUE) continue;
                // otherwise, try this path by updating the cost of the next potential node
                // if this path is less than the old route to get to next, then use the path from cur otherwise leave it same as before
                // when getting cost of cur, use the actual cost arr not temp since temp can get updated already in this iteration to make the path longer, but we need the path to not go over length i
                // for example in [0, 1, 100], [1, 2, 100] after iteration 0 temp[1] = 100, but after iteration 1 temp[2] should still be max val since if temp[2] becomes 100+100 then the path would become 0->1->2 which is of length 2, that's over i=1
                temp[next] = Math.min(temp[next], cost[curr]+price);
            }
            cost=temp;
        }
        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];
    }
}