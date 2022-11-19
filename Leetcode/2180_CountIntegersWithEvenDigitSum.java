class Solution {
    //     1.> what we observe is suppose a number x has sum of digit as even then x+1 will have sum of digit as odd and if x has sum of digit as odd then x+1 will have sum of digit as even
    // 2.> so for a sequence of numbers in between [1,n] both inclusive , alternatively we have odd sum of digits and even sum of digits.
    // 3.>so we can say for a number n , if sum of digit of n is even then our answer is n/2 otherwise it is (n-1)/2
        public int countEven(int num) {
            return (String.valueOf(num).chars().map(Character::getNumericValue).sum() % 2 == 0) ? num / 2: (num - 1) / 2;
        }
    }