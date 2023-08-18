class Solution {
    public int characterReplacement(String s, int k) {
        int maxConsec = 0, maxFreqInWindow = 0, count[] = new int[128];
        for (int i = 0; i < s.length(); ++i) {
            maxFreqInWindow = Math.max(maxFreqInWindow, ++count[s.charAt(i)]);
            // if maxconsec fits in the max freq window or it has enough 'operations' to be converted to fit in the max freq window after incrementing the cur window size, then we can increment the cur window size
            if (maxConsec < maxFreqInWindow + k) maxConsec++;
            // otherwise slide the left bound of window (decrement the count of the char that's going to be left out in nxt iteration')
            else count[s.charAt(i - maxConsec)]--;
        }
        return maxConsec;
    }
}