class Solution {
    // Find the index i of the next maximum number x [... x ...]
    // Reverse i + 1 numbers, so that the x will be at A[0] [x ... ...]
    // Reverse x numbers, so that x will be at A[x - 1] // given arr is a permutation, so each value will also have a corresponding index shifted by -1. Ex indices of any arr = [0,1,...,len-1]. arr is permutation from 1 to len so values = [1,...,len]
    // Repeat this process N times.
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        // for every 'value' from len to 1
        for (int value = arr.length, i; value > 0; --value) {
            // find its index, which should finish at arr[i]=value
            for (i = 0; arr[i] != value; i++);
            // reverse everything from 0 to i+1 exclusive so that value ends up at the head
            reverse(arr, i + 1);
            // add the index to the resulting arr, since we just reversed arr[0, i+1]
            res.add(i + 1);
            // reverse 'value' numbers, so that value will end up at arr[value-1] as it should in its sorted position
            reverse(arr, value);
            // add the value to the resulting arr since we just reversed arr[0, value]
            res.add(value);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }
}