class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curConsec = 0;
        int maxConsec = 0;
        for (int num: nums) {
            if (num == 1) curConsec++;
            else curConsec = 0;
            if (curConsec > maxConsec) maxConsec = curConsec;
        }
        return maxConsec;
    }
}