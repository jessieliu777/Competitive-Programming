class Solution {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int n = candyType.length;
        int count = 1;
        int i = 0;
        int j = 1;
        while (j  < n) {
            if (candyType[i] == candyType[j]) {
                j++;
            }else {
                count++;
                i = j;
                j++;
            }
        }
        return Math.min(count, n/2);
    }
}