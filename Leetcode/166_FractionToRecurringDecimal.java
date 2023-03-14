class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        // "+" or "-"
        // if the signs of numerator and denominator r diff, then it has to be negative, otherwise positive
        res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        // get the abs value of numerator and denominator
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part is the quotient
        res.append(num / den);
        // change num to be the remainder
        num %= den;
        // if no remainder, then we are done
        if (num == 0) return res.toString();
        // if there's remainder, pad . for the decimal
        res.append(".");
        // decimal part is the remainder
        // map[decimalPart] = length of decimalPart (num of digits)
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        // while there are still remaining remainder (decimalPart)
        while (num != 0) {
            // remainder = remainder * 10 / denominator
            num *= 10;
            // the quotient from remainder(old) * 10 / denominator is the next decimal
            res.append(num / den);
            num %= den;
            // if this decimalPart already occured before then it's repeating
            if (map.containsKey(num)) {
                // the starting index would value of the decimalPart in our map
                int index = map.get(num);
                // put bracket before that index, and put bracket at the end of cur result
                res.insert(index, "(");
                res.append(")");
                break;
            }
            // the starting index of the next decimalPart is the len of the result so far (+1 of the last index = len-1)
            else map.put(num, res.length());
        }
        return res.toString();
    }
}