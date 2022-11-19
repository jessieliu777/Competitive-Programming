class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stb = new StringBuilder();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (stb.length() == 0) {
                stb.append(s.charAt(i));
            } else if (s.charAt(i) == stb.charAt(count)) {
                stb.deleteCharAt(count);
                if (count!=0) count--;
            } else {
                stb.append(s.charAt(i));
                count++;
            }
        }
        return stb.toString();
    }
}