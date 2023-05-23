class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        // Just check or 01, 0011, 000111....
        // int res = 0;
        // String temp = "01";
        // while(temp.length() <= s.length()){
        //     if(s.contains(temp))
        //         res = temp.length();
        //     temp = "0" + temp + "1";
        // }
        // return res;

        int zeroCount = 0, oneCount = 0, totalMax = 0;
        int i = 0, len = s.length();
        while (i < len) {
            while (i < len && s.charAt(i) == '0') {
                zeroCount++;
                i++;
            }
            while (i < len && s.charAt(i) == '1') {
                oneCount++;
                i++;
            }
            totalMax = Math.max(totalMax, 2 *  Math.min(zeroCount, oneCount));
            zeroCount = 0;
            oneCount = 0;
        }
        return totalMax;
    }
}