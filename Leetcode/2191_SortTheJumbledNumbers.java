class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length, k = 0;
        Integer[] indices = new Integer[len];
        for (int i = 0; i < len; i++) indices[i] = i;
        // Sort the indices by the converted value first, if equal, then by original index.
        // Both java.util.Arrays.sort(T[] a, Comparator<? super T> c) and sorted() in Python are guaranteed to be stable, so no need to sub-sort by the index. 
        // cannot sort nums since cannot use comparator with int, so sort by indices
        Arrays.sort(indices, Comparator.comparing(i -> convert(nums[i], mapping)));
        return Stream.of(indices).mapToInt(i -> nums[i]).toArray();
    }

    private int convert(int num, int[] mapping) {
        if (num == 0) return mapping[0];
        int mappedNum = 0, f = 1;
        while (num > 0) {
            // add the mapping of ones digit * float point to n
            mappedNum += mapping[num % 10] * f;
            // increment float point to the next decimal value
            f *= 10;
            // truncate the digit we just mapped
            num /= 10;
        }
        return mappedNum;
    }
}