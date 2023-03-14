class Solution {
    public int findKthPositive(int[] arr, int k) {
        int missing = 0;
        int cur = 1;
        for (int num: arr) {
            while (cur < num) {
                missing++;
                if (missing == k) return cur;
                cur++;
            }
            if (missing == k) return cur;
            cur++;
        }
        // if we went through everything and still haven't missed k ints then keep going
        while (missing < k) {
            missing++;
            cur++;
        };
        return cur-1;
    }
}