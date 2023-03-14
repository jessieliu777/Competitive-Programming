class Solution {
    public boolean xorGame(int[] nums) {
    // 1. If on Alice's first turn, there are even amount of numbers left, then on any Alice's turn, there will be even amount of numbers left, nothing can change that.
    // 2. The only way to make your opponent lose on the immediate next turn, is to let the them face ODD amount of the SAME number. Because assuming Alice faces even:
        // 2.1 If the numbers are not all the same, then there are at least 2 numbers x y such that x != y -> Alice can always choose between two numbers the one that won't lose immediately
        // 2.2 If the number are all the same but the amount is even, then Alice already wins since the xor of even amount of same number has to be 0 (x^x = 0 -> x^x ... even times = 0)

    // therefore Alice will win if
    // 1. If xor == 0
    // 2. If xor != 0 and length of numbers is even

        int xor = 0;
        for (int i: nums) xor ^= i;
        return xor == 0 || nums.length % 2 == 0;
    }
}