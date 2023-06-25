class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        // given if no chars greater than target exist, return the first letter, can do that by setting target to be the first letter
        if (target >= letters[len - 1]) target = letters[0];
        // finding the first letter greater than target leqv finding the first letter at least as great as target
        else target++;
        
        // binary search
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] == target) return letters[mid];
            // if cur letter to low, move the low window to past mid
            if (letters[mid] < target) lo = mid + 1;
            // otherwise move the high window to be at mid. note not mid-1 incase that becomes too small
            else hi = mid;
        }
        return letters[hi];
    }
}