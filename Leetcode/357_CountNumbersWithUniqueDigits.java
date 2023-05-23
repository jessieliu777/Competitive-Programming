class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1; // 10^0 == 1, so 0 is the only number in the range.
        int result = 10; // if n == 1 => numbers < 10^1 => numbers with only one digit [0, 9]. we know n >= 1 as it got here.
        // now for n == 2, keep the count from n = 1, now count 2 digits numbers. the first digit have to be from 1 to 9 since no leading 0, otherwise it's not 2 digits So in total 9 choices for first digits. the second can be from 0 to 9 however exclude the repeated one from first digit so 10 choices - 1 = 9 choices. Total is 9 * 9 choices for 2 digits. Note we keep the count from n == 1 so total 10 + 9*9
        // similar for n = 3, same story for first 2 digits. the third digit cannot repeat from the previous digit so 9 * 9 * 8. Keep the results from n < 2 so 10 + 9 * 9 + 9 * 9 * 8
        int choicesCur = 9, choicesTotal = 9;
        for (int i = 1; i < n; i++) {
            choicesTotal *= choicesCur--;     // number of numbers with with i unique digits
            result += choicesTotal;
        }
        return result;
    }
}