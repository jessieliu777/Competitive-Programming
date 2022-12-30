class Solution {
    public boolean canWinNim(int n) {
        // the person who takes the 4th stone loses
        return n % 4 > 0;
    }
}