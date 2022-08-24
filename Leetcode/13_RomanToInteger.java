class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++){
            switch(s.charAt(i)) {
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (i < len-1){
                        if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'){
                            result -= 10;
                        } else {
                            result += 10;
                        }
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (i < len-1) {
                        if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M'){
                         result -= 100;
                        } else {
                         result += 100;
                        }
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                // default is when char is I
                    if (i < len-1){
                        if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'){
                            result -= 1;
                        } else {
                            result++;
                        }
                    } else {
                        result++;
                    }
            }
        }
        return result;
    }
}