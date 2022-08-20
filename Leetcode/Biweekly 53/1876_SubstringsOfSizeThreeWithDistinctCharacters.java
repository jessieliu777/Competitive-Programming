class Solution {
    public int countGoodSubstrings(String s) {
        if (s.length() <= 2){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length()-2; i ++){
            String cur = s.substring(i, i+3);
            if (cur.charAt(0) != cur.charAt(1) && cur.charAt(0) != cur.charAt(2) && cur.charAt(1) != cur.charAt(2)){
                result++;
            }
        }
        return result;
    }
}