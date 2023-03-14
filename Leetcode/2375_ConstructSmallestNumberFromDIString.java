class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder(), stack = new StringBuilder();
        // given each digit from 1 to 9 can be used at most once, then pattern len is at most 8
        // so we can use the index from iterating through pattern as potential digit
        for (int i = 0; i <= pattern.length(); i++) {
            // let cur index be index + 1. Add it to our stack
            stack.append((char)('1' + i));
            // every time we reach an I, reverse our stack and append it to result.
            // In the case of consec I's, for each I, the stack would only have one number in it. For example II, the stack would contain 1 digit at the first I, and 1 digit again at the second I. If we started from 0th iteration, then II -> 
            // first I: stack = 1, res = "" + stack.reverse() = "" + 1 = 1 
            // second I: stack = 2, res = "" + stack.reverse() = "" + 2 = 2
            // In the case where D preceds I, it is trivial why reversing an increasing stack results in decreasing
            // For example DI:
            // D: stack = 1
            // I: stack = 12, res = "" + stack.reverse() = "" + 21 = 21
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }
}