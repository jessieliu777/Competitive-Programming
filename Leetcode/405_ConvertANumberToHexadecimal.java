class Solution {
    public String toHex(int num) {
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            // take the last 4 digits of the bin repr of num => num & 2^4-1, add the hex repr of that to result
            result = map[(num & 15)] + result; 
            // shift num by 4
            num = (num >>> 4);
        }
        return result;
    }
}