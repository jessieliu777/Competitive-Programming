class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            // any non existant digits to the left of i, j is treated as 0. For example num1 = 11, num2 = 123, then treat num1 as 011. so when i = index of num1 is less than 0, take the value as 0
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            // append only the ones digit to result and store the carry if the result has 2 digits
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        // since we append the RHS first, reverse to get the right order back
        return sb.reverse().toString();
    }
}