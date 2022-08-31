class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length+1];
        minCost[0] = 0;
        if (cost.length == 1) return cost[0];
        minCost[1] = 0;
        if (cost.length == 2) return Math.min(cost[0], cost[1]);
        for (int i = 2; i <= cost.length; i++){
            // min cost to get to current stair is the min cost of the smaller of the cost it takes to reach the prev stair + the cost of that stair to this stair, and the cost it takes to reach the prev prev + the cost of prev prev to this stair
            minCost[i] = Math.min(minCost[i-1]+cost[i-1], minCost[i-2]+cost[i-2]);
        }
        return minCost[cost.length];
    }
}