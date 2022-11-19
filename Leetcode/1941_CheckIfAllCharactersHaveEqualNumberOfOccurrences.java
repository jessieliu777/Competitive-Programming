class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] a = new int[26];
        char[] c = s.toCharArray();
        for(char i : c) {
            a[i-'a']++;
        }
        int t = a[c[0]-'a'];
        for(int i : a) {
            if(i!=t && i!=0)
                return false;
        }
        return true;
    }
}