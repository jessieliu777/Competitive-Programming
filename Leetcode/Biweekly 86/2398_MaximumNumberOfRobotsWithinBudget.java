class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        // use 2 pointers
        // left start with the 0th robot, right keep going until we reach a robot that can't be charged.
        // save the streak count, then move the left pointer
        int left = 0;
        int right = 0;
        // use priority queue to get the max time
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        long sumCosts = 0;
        int countRobots = 0; 
        int maxCountRobots = 0;
        while (right < chargeTimes.length){
            int[] pqItem = {chargeTimes[right], right};
            pq.offer(pqItem);
            long cost = Math.max(pq.peek()[0], (long) chargeTimes[right]) + (long)(countRobots+1) * (long)(runningCosts[right] + sumCosts);
            if (cost <= budget){
                countRobots++;
                maxCountRobots = Math.max(countRobots, maxCountRobots);
                sumCosts += runningCosts[right];
                right++;
            } else {
                countRobots--;
                // if max time is the one we have to remove from the streak, update it
                while (!pq.isEmpty() && pq.peek()[1] <= left) pq.poll();
                sumCosts -= runningCosts[left];
                left++;
                // make sure right isn't before left
                if (right < left){
                    right = left;
                    // reset streak
                    countRobots = 0;
                    pq.clear();
                    sumCosts = 0;
                }
            }
        }
        return maxCountRobots;
    }
}