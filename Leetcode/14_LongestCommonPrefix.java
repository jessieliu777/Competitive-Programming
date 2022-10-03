class Solution {
    public String longestCommonPrefix(String[] strs) {
        // for every char in the first string
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            // for every other string
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);             
            }
        }
        return strs[0];
    }
}