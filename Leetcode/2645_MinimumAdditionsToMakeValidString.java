class Solution {
    public int addMinimum(String word) {
        // Same problem:
        // Find out the minimum k where word is subsequence of "abc" repeated k times.
        // Since "abc" is increasing, split the original word into k strict increasing subarray.
        int abcCount = 0, prev = 'd', len = word.length();
        // go thru every word
        for (int i = 0; i < len; i++) {
            // if cur word is less than prev then we need to start a new subarr of 'abc', otherwise no need
            abcCount += word.charAt(i) <= prev ? 1 : 0;
            prev = word.charAt(i);
        }
        // number of chars to add = number of chars of st abc is repeated k times where k is minimal - original len = 3k - len
        return abcCount * 3 - len;
    }
}