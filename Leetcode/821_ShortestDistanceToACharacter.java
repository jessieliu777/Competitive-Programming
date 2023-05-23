class Solution {
    public int[] shortestToChar(String s, char c) {
        int len = s.length(), mostRecentOccurence = -len, res[] = new int[len];
        // forward pass to get the most recent distance to the left of cur index
        for (int i = 0; i < len; ++i) {
            // if there's an occurence of c update pos
            if (s.charAt(i) == c) mostRecentOccurence = i;
            // mostRecentOccurence is init to be -len, so init res[i] is going to be len of s which is upper bound
            res[i] = i - mostRecentOccurence;
        }
        // backward pass to get the most recent distance to the right of cur index, and calculate min of most recent left, most recent right
        // no need to reset mostRecentOccurence as forward pass should make it the rightest  occurence
        // no need to start backward pass at the right of the array because everything to the right of the mostRecentOccurence from forward pass should be pointiing to it anyways, so no point of updating those
        for (int i = mostRecentOccurence - 1; i >= 0; --i) {
            if (s.charAt(i) == c)  mostRecentOccurence = i;
            res[i] = Math.min(res[i], mostRecentOccurence - i);
        }
        return res;
    }
}