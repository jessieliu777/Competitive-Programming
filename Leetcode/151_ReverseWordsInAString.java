class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        for (int i = 0; i < str.length/2; i++){
            String temp = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = temp;
        }
        return Arrays.toString(str).replace("[", "").replace("]", "").replace(",", "");
    }
}