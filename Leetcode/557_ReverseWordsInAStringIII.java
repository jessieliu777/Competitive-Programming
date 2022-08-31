class Solution {
    // from #344
    public void reverseString(char[] s) {                     
        for (int i = 0; i < s.length/2; i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }
    
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length; i++){
            char[] cur = str[i].toCharArray();
            reverseString(cur);
            result.append(String.valueOf(cur) + " ");
        }
        return result.toString().trim();
    }
}