class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0;
        for (char c : str2.toCharArray()) {
            char decremented = (c == 'a') ? 'z' : (char) (c - 1);
            // skip all chars in str1 that's 'is not the decremented char to perform op on or the cur char
            while (i < str1.length() && (str1.charAt(i) != c && str1.charAt(i) != decremented)) i++;
            if (i >= str1.length()) return false;
            i++;
        }
        return true;
    }
}