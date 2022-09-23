class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) return true;
        int cur = 0;
        boolean result = false;
        for (int i = 0; i < t.length(); i++){
            if (t.charAt(i) == s.charAt(cur)){
                cur++;
                if (cur == s.length()) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}