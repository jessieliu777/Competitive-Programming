class Solution {
    public boolean isPowerOfFour(int n) {
        int i = 0;
        double pow = 1;
        while (pow <= n){
            pow = Math.pow(4, i);
            if (Math.pow(4, i) == n) {
                return true;
            }
            i++;
        }
        return false;
    }
}