class Solution {
    public int totalFruit(int[] fruits) {
        // "Start from any index, we can collect at most two types of fruits. What is the maximum amount"
        // LEQV Find out the longest length of subarrays with at most 2 different numbers?

        // Solve with sliding window,
        // and maintain a hashmap counter, which count the number of elements between the two pointers.
        
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        // sliding window: start = i, end = j
        for (j = 0; j < fruits.length; j++) {
            // pick the jth fruit, update the count of j's type
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            // if we've picked more than 2 types of fruit then we must remove one
            if (count.size() > 2) {
                // remove the fruit from the beginning of the 'window'
                count.put(fruits[i], count.get(fruits[i]) - 1);
                // LEQV to if (count.get(fruits[i++]) == 0) count.remove(fruits[i]);
                // if there are no more fruits of that type remove it fromm map
                count.remove(fruits[i++], 0);
                // Even if we moved on from the correct 'window' but only the window size matter, so as long as we end eventually the optimal window size will stay optimal.
                // For ex [1, 2, 3, 2, 2, 1, 5, 6, 7, 8, 9, 0]
                // opt subarr = [2, 3, 2, 2] => len = 4
                // j = 0, i = 0, map={1:1}
                // j = 1, i = 0, map={1:1, 2:1}
                // j = 2, i = 1 map={2:1, 3:1}
                // j = 3, i = 1 map={2:2, 3:1}
                // j = 4, i = 1 map={2:3, 3:1}
                // j = 5, i = 2, map={2:2, 3:1, 1:1}
                // even tho the rules say we must stop since we reached a tree with 3 types of fruit if we picked but notice the sum of values is still = 2+1+1 = 4, which is same as prev iteration sum of values 1+1+1+1. So even if we take this step and return here, the result will be the same so it doesn't matter if we take it. Same logic with all other iterations after this. Note: j-i is also the same difference as prev iteration
                // j = 6, i = 2, map={1:1, 5:1}
                // j = 7, i = 3, map={1:1, 2:1, 5:1, 6:1}
                // j = 8, i = 4, map={1:1, 5:1, 6:1, 7:1}
                // j = 9, i = 5, map={5:1, 6:1, 7:1, 8:1}
                // j = 10, i = 6, map={6:1, 7:1, 8:1, 9:1}
                // j = 11, i = 7, map={7:1, 8:1, 9:1, 0:1} => sum of values still = 4 as wanted
                // which is also j-i (note after the for loop ends j++) = 12 - 8 = 4
            }
        }
        return j - i;

    }
}