class Solution {
    public boolean lemonadeChange(int[] bills) {
        // When the customer gives us $20, we have two options: 
        // 1. To give three $5 in return
        // 2. To give one $5 and one $10.
        // On insight is that the second option (if possible) is always better than the first one.
        // Because two $5 in hand is always better than one $10

        int five = 0, ten = 0;
        // go through every bill
        for (int bill : bills) {
            // if customer pays 5, then no change needed and we have one more $5
            if (bill == 5) five++;
            // if customer pays 10, we give them $5 change (lose $5), and we get one more $10
            else if (bill == 10) {
                five--; 
                ten++;
            }
            // given customer pays $5, $10, or $20, if they didn't pay $5 or $10 for sure they paid $20
            // so try to see if we have any more $10, if so, give them change of $10, and $5
            else if (ten > 0) {
                ten--; 
                five--;
            }
            // otherwise we have no $10, so we have to give 3 $5
            else five -= 3;
            // if we run out of $5, then we cannot provide correct change
            if (five < 0) return false;
        }
        return true;
    }
}