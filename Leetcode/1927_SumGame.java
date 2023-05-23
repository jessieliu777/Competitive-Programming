class Solution {
    public boolean sumGame(String num) {
        // if already equal then bob wins
        // if odd number of ? then Alice wins
        // if even number of ? then divide them in to pairs. For single pair of ?? The sum must be exactly 9
        // If "??" > 9 , Alice just put "0" in place of one "?", now Bob can't put number greater than 9. (Example "??91", Alice put "0?91" , Bob loses)
        // If "??" < 9 , Alice just put "9" in place of one "?", now Bob can't put negative number (Example "??61", Alice put "9?61" , Bob loses)
        // By induction, for k pairs of ?? The sum must be exactly k * 9
        // now since we know the pair sum must be 9, the expected digit of a single ? is 9/pair length = 9/2 = 4.5 so we can treat each ? as 4.5
        // Since left sum = right sum => Bob wind then left sum - right sum = 0 => Bob win
        // So to check for that, add all the digits in the first half and deduct all the digits in the last half. If the result is 0 then we achieved left sum = right sum, which Bob wins
        int len = num.length();
        double res = 0;
        for (int i = 0; i < len; i++) res += (i < len/2 ? 1 : -1) * (num.charAt(i) == '?' ? 4.5 : num.charAt(i) - '0');
        return res != 0;
    }
}