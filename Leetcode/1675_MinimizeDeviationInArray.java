class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int n = nums.length, min = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        // Since odd can only be doubled once & even can not be doubled then double all odds first.
        for (int num : nums) {
            if (num % 2 == 1) num *= 2;
            pq.add(num);
            // add the doubled num to pq
            min = Math.min(min, num);
        }
        // since all odds are doubled now everything is even. For all evens, we can attempt to divide by 2 reduce the max since min has to be positive, reducing the max as much as possible reduces the deviation
        while (true) {
            int cur = pq.poll(); // max queue, so num is max num of the queue
            res = Math.min(res, cur - min);
            // if cur num is odd then we are done. We already reached the min b4 by iterating through the original arr, case 1 the min remains unchanged: then continuing any furthur would only give us num between max and min inclusive. this num is max so deviation has to be this num - min. If true max is even higher then we wouldn't even get here. case 2 the min can be even smaller by dividing future queue numbers: again max is this num since if there was any higher undivided it would have to be odd and would've broken out of the loop earlier. However, having a even smaller min would increase the deviation num - min, so since max is set we want to maximize the min here -> continuin can only potentially reduce min which increases deviation, so don't continue
            if (cur % 2 == 1) break; 
            // if the number is even, check for its deviation and store it if it's minimal. Otherwise, try to divide by 2 in attempt to reduce the min. if the reducing the min increases eviation, then it wouldn't take the increased deviation as we already stored this deviation. Otherwise, we can take the potential future deviations
            min = Math.min(min, cur / 2);
            pq.add(cur / 2);
        }
        return res;
    }
}