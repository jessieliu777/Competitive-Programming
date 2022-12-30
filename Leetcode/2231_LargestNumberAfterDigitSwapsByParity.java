class Solution {
    public int largestInteger(int num) {
        // Look for a digit on the right that is bigger than the current digit and has the same parity, and swap them.
        char[] numArr = String.valueOf(num).toCharArray();
        for(int i = 0; i < numArr.length; i++)
            for(int j = i + 1; j < numArr.length; j++)
                // (numArr[j] - numArr[i]) % 2 == 0 means both terms have to be even or both have to be odd
                // altertatively ( ( a[j] > a[i] ) && ( a[j] - a[i] ) &1 ) == 0 ) for less expensive than %
                if(numArr[j] > numArr[i] && (numArr[j] - numArr[i]) % 2 == 0){
                    char t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
        return Integer.parseInt(new String(a));
    }
}