class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // Intuition
        // Calculate the time % 60 then it will be exactly same as two sum problem.


        // Explanation
        // t % 60 gets the remainder from 0 to 59.
        // We count the occurrence of each remainders in a array/hashmap c.

        // we want to know that, for each t,
        // how many x satisfy (t + x) % 60 = 0.

        // The straight forward idea is to take x % 60 = 60 - t % 60,
        // which is valid for the most cases.
        // But if t % 60 = 0, x % 60 = 0 instead of 60.

        // better solution is to use x % 60 = (60 - t % 60) % 60,
        // the other idea is to use x % 60 = (600 - t) % 60.

        int count[]  = new int[60], res = 0;
        for (int t : time) {
            res += count[(60 - t % 60) % 60];
            count[t % 60] += 1;
        }
        return res;
    }
}