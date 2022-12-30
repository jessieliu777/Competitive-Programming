class Solution {
    public int numRabbits(int[] answers) {
        int c[] = new int[1000], res = 0;
        // for every rabbit's answer i that participated
        // the first time the answer i was heard, we count it. For every other i times, no need to count since they in the least case refer to the same group. Once it exceeds i + 1 times it is the 2nd group and so on (for example for the i+2nd time the colour was reported, that participant is in the second group as the first i+1 participants can be in the same colour in the least case).
        for (int i : answers) if (c[i]++ % (i + 1) == 0) res += i + 1;
        return res;
    }
}