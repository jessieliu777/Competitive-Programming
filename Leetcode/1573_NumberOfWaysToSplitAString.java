class Solution {
    public int numWays(String s) {
        // In order to have N substrings, we need to cut input string N - 1 times, so we will have N - 1 blocks. Then, we have b1, b2, b3, b4, ... ...b(n-1). Each of the blocks needs to have number of ones = total number of ones / N. And let's assume the number of ways to split string for each cut is Wi, so the total number of ways to cut will be W1 x W2 x W3 x ... ...x Wn-1. I didn't code this yet. I think you guys are smart enough to get an answer.

        // Count the total number of the 1s, if not divisible by 3, then return 0;
        // If the count is 0, then we can choose 1st 0 as our 1st cut, correspondingly, the 2nd cut between the other 2 non-empty subarrays will have n - 2 options, where n = s.length(); Similarly, we can also choose 2nd 0 as 1st cut, then we have n - 3 options for the 2nd cut, ..., etc, totally, the result is (n - 2) + (n - 3) + ... + 2 + 1 = (n - 2) * (n - 1) / 2;
        // Otherwise, traverse the input array: count the 1s again, if the count reaches the 1 / 3 of the totoal number of 1s, we begin to accumulate the number of the ways of the 1st cut, until the count is greater than 1 / 3 * total ones; when the count reaches the 2 / 3 of the total number of the 1s, start to accumulate the number of the ways of the 2nd cut, until the count is greater than 2 / 3 * total ones;
        // Multification of the numbers of the ways of 1st and 2nd cuts is the result..

        long res = 0, len = s.length(), mod = 1_000_000_007, ones = 0;
        if (len < 3) return 0;
        // get the number of 1s in the str
        for (int i = 0; i < len; i++) if (s.charAt(i) == '1') ones += s.charAt(i) - '0';

        if (ones % 3 != 0) return 0;
        // if no ones then the number of ways is the combination of select 2 slots from n - 1 slots;
        if (ones == 0) return (int) ((len - 1) * (len - 2) / 2 % mod); 

        long waysOfFirstCut = 0, waysOfSecondCut = 0, onesInEachSplitedBlock = ones / 3, count = 0;
        for (int i = 0; i < len; i++) {
            count += s.charAt(i) - '0';
            if (count == onesInEachSplitedBlock) waysOfFirstCut++; // btwn s1 and s2;
            else if (count == onesInEachSplitedBlock * 2) waysOfSecondCut++; // btwn s2 and s3;
        }
        return (int) (waysOfFirstCut * waysOfSecondCut % mod);  // two 0s form 3 slots
    }
}