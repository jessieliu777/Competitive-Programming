class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

		int[] digits = new int[num1.length() + num2.length() - 1];
        
        // add all the digits without carry over
        // for every digit in num1
		for (int i = 0; i < num1.length(); i++) {
            // for every digit in num2
			for (int j = 0; j < num2.length(); j++) {
                // digits[i+j] += ith digit of num1 * jth digit of num2
				digits[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
        // add the carry over digit
		for (int i = digits.length - 1; i > 0; i--) {
			digits[i - 1] += digits[i] / 10;
			digits[i] %= 10;
		}
        
        // convert to string
		StringBuilder sb = new StringBuilder();
		for (int i : digits) {
			sb.append(i);
		}

		return sb.toString();
    }
}