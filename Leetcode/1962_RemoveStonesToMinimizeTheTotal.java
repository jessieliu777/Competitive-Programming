class Solution {
    public int minStoneSum(int[] piles, int k) {
        // apply operation on the highest number of piles first
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b - a); // from high to low
        int res = 0;
        // add every pile to pq and res
        for (int pile : piles) {
            pq.add(pile);
            res += pile;
        }
        // for k times
        while (k-- > 0) {
            // remove highest pile
            int pile = pq.poll();
            // add the pile back after removing pile/2 stones
            pq.add(pile - pile / 2);
            // remove the pile/2 from result
            res -= pile / 2;
        }
        return res;
    }
}