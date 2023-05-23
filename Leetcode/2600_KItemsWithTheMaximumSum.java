class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int result = 0;
        while (k-- > 0) {
            if (numOnes > 0) {
                numOnes--;
                result++;
            }
            else if (numZeros > 0) numZeros--;
            else {
                numZeros--;
                result--;
            } 
        }
        return result;
    }
}