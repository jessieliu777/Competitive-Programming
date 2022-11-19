class Solution {
    public boolean squareIsWhite(String coordinates) {
        int ch = coordinates.charAt(0) - 'a';
        int num = coordinates.charAt(1) - '0';
        return ch % 2 == num % 2;
    }
}