class Solution {
    public int titleToNumber(String columnTitle) {
        int output = 0;
        for(char c: columnTitle.toCharArray()) {
            output = output * 26 + (c - 'A' + 1);    
        }
        return output;
    }
}