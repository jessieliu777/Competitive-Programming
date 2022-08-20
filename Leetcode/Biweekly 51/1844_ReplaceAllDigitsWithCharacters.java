class Solution {
    public String replaceDigits(String s) {
        String result = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 1; i < s.length(); i+=2){
            char pre = s.charAt(i-1);
            int cur = s.charAt(i) - '0';
            result += "" + pre;
            int index = alphabets.indexOf(pre);
            result += "" + alphabets.charAt(index+cur);
        }
        if (s.length() % 2 == 1){
            result += s.charAt(s.length()-1);
        }
        return result;
    }
}