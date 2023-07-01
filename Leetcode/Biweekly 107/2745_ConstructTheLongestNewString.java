class Solution {
    public int longestString(int x, int y, int z) {
        // try to match every AA with BB and vice versa
        // min(x, y)* 4 takes care of all the AA's  and BB's that can be 'matched' Ex "AABBAABB..." or "BBAABBAA..."
        // min(abs(x-y) , 1)*2 takes care of any 'leftovers' in case x != y so some pair doesn't have match. We can only take one such pair to avoid repetition. For example x = 3, y = 1, matched = "AABB", we can only take one more "AA" even tho there's 2 more. So for this case total 'leftover' is only 2. Of course, when x == y, there's no leftover.
        // z*2 is the number of letters for z amount of ABs, since AB can just keep appending to itself "ABABAB..."
        return Math.min(x,y)*4 + Math.min(Math.abs(x-y), 1)*2 + z*2;
    }
}