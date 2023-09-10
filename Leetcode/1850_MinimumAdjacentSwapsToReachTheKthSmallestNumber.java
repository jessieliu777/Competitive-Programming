class Solution {
    
    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp; 
    }

    /**
    reverse nums[i:]
     */
    public void reverse(char[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    // get the next largest num thats a permutation of input
    public void nextPermutation(char[] nums) {
        if (nums.length == 0) return;
        int len = nums.length;
        // go through every digit from rhs
        for (int i = len - 1; i >= 1; i--) {
            // if it's larger than the lefter digit then reverse everything from cur digit to end
            if (nums[i] > nums[i - 1]) {
                reverse(nums, i);
                // now nums = nums[:i], nums[len-1],.., nums[i]
                // go through every digit from cur index til end (the reversed portion)
                for (int j = i; j < len; j++) {
                    // if any of these is larger than the digit to the left of i, then swap them and we are done
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0);
    }

    private int countSwaps(char []s1, char[] s2, int size) {
        // i = s1 index
        int i = 0;
        int count = 0;
        while (i < size) {
            int j = i;
            // skip all the chars in s2 that's not s1[i], we will end up arriving at s2[j] for some j > i since both strs are permutations and even if j < i before, in the prev iteration it would've been swapped to some j after. Note if s2[i] = s1[j] nothing happens this iteration
            while (s1[j] != s2[i]) j += 1;
            // keep swapping s2[j] with adj chars until it reachs s2[i], keep counting the swaps
            while (i < j) {
                swap(s1, j, j - 1);
                j -= 1;
                count++;
            }
            i++;
        }
        return count;
    }

    public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray();
        // find the next largest permutation 1 to k times, after k times we found the kth smallest next largest permutation
        for (int i = 0; i < k; i++) nextPermutation(arr);
        char[] ori = num.toCharArray();
        // count how many swaps needed to perform to reach the kth smallest permutation
        return countSwaps(ori, arr, arr.length);
    }
}