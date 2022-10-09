class ATM {
    private long[] count;
    private int[] denominations;
    public ATM() {
        count = new long[5];
        denominations = new int[] {20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++){
            count[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        for (int i = 4; i >= 0; i--) {
            // if the amount is more than what we have for denominations i
            if (amount > denominations[i]*count[i])
                // then we need count i of denomination i
                result[i] = (int) count[i];
            else
                // otherwise only withdraw the amount we need
                result[i] = (int) amount/denominations[i];

            amount -= (long) denominations[i]*result[i];
            // don't go past zero
            if (amount == 0) break;
        }
        // if there's leftover amount then we couldn't withdraw all the amount given
        if (amount > 0) return new int[]{-1};
        
        // remove withdrawed amount from count
        for (int i = 0; i < 5; i++) count[i] -= result[i];

        return result;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */