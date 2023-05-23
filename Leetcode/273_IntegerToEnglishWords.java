class Solution {
    final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] THOUSANDS = {"Billion", "Million", "Thousand", ""};
    final int[] radix = {1000000000, 1000000, 1000, 1};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < radix.length; i++) {
            // if num is divisible by thousands then we need to get the highest digit in the next iteration + the word 'thousand'
            if (num / radix[i] == 0) continue;
            // if num isn't divisible by thousands then get the word without the thousands part + the correct thousands word
            sb.append(helper(num / radix[i])).append(THOUSANDS[i]).append(' ');
            // divide num by radix to go to the next word in THOUSANDS
            num %= radix[i];
        }
        return sb.toString().trim();
    }
    
    private String helper(int num) {
        if (num == 0) return "";
        // if 1 <= num < 20 then use the less than 20 word
        else if (num < 20) return LESS_THAN_20[num] + " ";
        // if 21 <= num < 100 then the word is word with 10 multiplier + word without 10 multiplier
        else if (num < 100) return TENS[num / 10] + " " + helper(num % 10);
        // if num >= 101 then the word is word of num left of hundreds decimal + word of digits not in the hundreds place
        else return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}