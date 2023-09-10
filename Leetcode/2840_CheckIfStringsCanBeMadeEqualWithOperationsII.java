class Solution {
    public boolean checkStrings(String s1, String s2) {
        // count of occurences in odd, even indices that occurs strictly in s1. if there's more occurences n s2, denote by negative
        int[] odd = new int[26], even = new int[26];
        for (int i = 0; i < s1.length(); ++i) {
            if (i % 2 == 1) {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            } else {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            }
        }
        // go through every char, if the number of occurences don't even out, then s1, s2 can't be made equal
        for (int i = 0; i < odd.length; ++i) {
            if (odd[i] != 0 || even[i] != 0) return false;
        }
        return true;
    }
}