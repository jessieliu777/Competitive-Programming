class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    // If there are count zeroes in between two 1s, then how many 1s can we place in those zeroes without violating the given condition? Answer is (count-1)/2. The only cases this doesn't apply are when there are zeroes(1 or more)

    // At the beginning of the array.
    // At the end of the array.
    // For these 2 cases, the number of 1s that we can place is count/2. But to generalize the algorithm and to simplify code inside loop, count has been initialized to 1 for the first time and result += (count-1)/2 effectively becomes result += count/2 for the case 1. For case 2, result is updated outside the loop, again by count/2 times. Note when flowerbed is surrounded by 2 1's then the first count get's zeroed out in the iteration that reached the left 1, so initialize count to 1 works out.

    // Finally, we check if the number of possible 1s that we can place is greater than or equal to n. If so, we return true else false.
        int zerosCount = 1;
        int result = 0;
        for (int i=0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) zerosCount++;
            else {
                result += (zerosCount-1)/2;
                zerosCount = 0;
            }
        }
        result += zerosCount/2;
        return result >= n;
    }
}