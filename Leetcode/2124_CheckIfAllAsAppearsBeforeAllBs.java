class Solution {
    public boolean checkString(String s) {
        boolean checkB = false;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a' && checkB) return false;
            if (s.charAt(i) == 'b') checkB = true;
        }
        return true;
    }
}