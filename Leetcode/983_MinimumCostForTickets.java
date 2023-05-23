class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // using queue so that the oldest ticket is at the top. 
        Queue<int[]> last7days = new LinkedList<>(), last30days = new LinkedList<>();
        
        int totalCost = 0;
        for(int i=0; i < days.length; i++){
        	// discarding expired 7days pass
            while(!last7days.isEmpty() && last7days.peek()[0] + 7 <= days[i]) last7days.poll();
            // discarding expired 30 days pass.
            while(!last30days.isEmpty() && last30days.peek()[0] + 30 <= days[i]) last30days.poll();
            
            // add cur day to the 7 day ad 30 day pass
            last7days.offer(new int[]{days[i], totalCost + costs[1]});
            last30days.offer(new int[]{days[i], totalCost + costs[2]});
            
            // taking the min of daily pass, 7 days, 30 days pass. 
            totalCost = Math.min(totalCost + costs[0], Math.min(last30days.peek()[1], last7days.peek()[1]));
        }
        
        return totalCost;
    }
}