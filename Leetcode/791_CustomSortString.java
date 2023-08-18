class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) ++count[c - 'a'];
        StringBuilder sb = new StringBuilder();
        // for every char in order, add all copies of it appearing s to sb if exists
        for (char c : order.toCharArray()) while (count[c - 'a']-- > 0) sb.append(c); 
        // gfor every char leftover from above (all chars not in order), add to sb
        for (char c = 'a'; c <= 'z'; ++c) while (count[c - 'a']-- > 0) sb.append(c); 
        // result should be all copies of chars s in order + leftover chars of s not in order
        return sb.toString();
    }
}