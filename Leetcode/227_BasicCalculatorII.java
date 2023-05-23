class Solution {
    public int calculate(String s) {
        // let term be the result of *, / before the most recent +, -. If dne, it s just the sole number
        int sum = 0, term = 0, num = 0, len = s.length();
        // pad in + sign in front of the experiences, this doesn't change the expression
        char lastSign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // if it s a digit then append the digit to the ones decimal place
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            // at the last char, need to update term from last sign
            if (i == len - 1 || !Character.isDigit(c) && c!=' ') {
                switch(lastSign) {
                    case '+':
                        sum += term;
                        term = num;
                        break;
                    case '-':
                        sum += term;
                        term = -num;
                        break;
                    case '*':
                        term *= num;
                        break;
                    case '/':
                        term /= num;
                        break;
                }
                lastSign = c;
                num = 0;
            }
        }
        sum += term;
        return sum;
    }
}