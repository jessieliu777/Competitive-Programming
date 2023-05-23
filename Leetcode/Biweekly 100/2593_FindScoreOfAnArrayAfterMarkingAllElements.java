class Solution {
    public long findScore(int[] nums) {
        int len = nums.length; long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> nums[i] == nums[j] ? i - j : nums[i] - nums[j]);
        boolean[] marked = new boolean[len];
        for(int i=0; i<len; i++) pq.offer(i);

        while(!pq.isEmpty()){
            int min = pq.poll();
            if(marked[min]) continue;
            score += nums[min];
            marked[min] = true;
            // mark adj elements if exists
            if(min > 0) marked[min-1] = true;
            if(min < len-1) marked[min+1] = true;
        }
        return score;
    }
}