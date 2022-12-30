class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum(), part = 0,cnt = 0;
        if (sum % 3 != 0) return false;
        int average = sum / 3;
        for (int a : arr) {
            part += a;
            if (part == average) { // find the average: sum / 3
                cnt++; // find an average, increase the counter.
                part = 0; // reset part.
            }
        }
        return cnt >= 3 && sum % 3 == 0;
    }
}