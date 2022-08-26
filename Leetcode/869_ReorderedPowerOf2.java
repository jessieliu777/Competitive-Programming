class Solution {
    public int[] getDigitOccurence(int n){
        int[] result = new int[10];
        while (n > 0){
            // the remainder is the current digit
            int remainder = n % 10;
            result[remainder]++; // increment occurence count
            n /= 10; // truncate the remainder
        }
        return result;
    }
    public boolean reorderedPowerOf2(int n) {
        if (n == 1) return true; // edge case
        // count the number of occurence for each digit 
        int[] occurence = getDigitOccurence(n);
        for (int i = 1; i < 30; i++){
            int cur = 1 << i; // shift left (equivalent to multiplying by 2)
            if (Arrays.equals(occurence, getDigitOccurence(cur))){
                return true;
            }
        }
        return false;
    }
}