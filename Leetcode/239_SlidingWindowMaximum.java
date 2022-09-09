class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        // stores elements from greatest to least
        Deque<Integer> deque =new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            // remove elements from the deque if the window size would be bigger than k
            if(!deque.isEmpty() && deque.peek()==i-k){
                deque.poll();
            }
            // for any values less than i, take that out since we only need the max
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            // add current index to deque
            deque.offer(i);
            // if we went through everything in this window, add the max value in this window
            if(i>=k-1){
                result[index++]=nums[deque.peek()];
            }
        }
        return result;
    }
}