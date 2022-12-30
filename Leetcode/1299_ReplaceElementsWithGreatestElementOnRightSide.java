class Solution {
    public int[] replaceElements(int[] arr) {
        int greatest = -1;
        for (int i = arr.length-1; i >= 0; i--){
            int cur = arr[i];
            arr[i] = greatest;
            if (cur > greatest){
                greatest = cur;
            }
        }
        return arr;
    }
}