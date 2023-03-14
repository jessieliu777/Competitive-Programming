class Solution {
    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i = 0;
        while(i < len) {
            // reverse everything from j to k
            int j = Math.min(i + k - 1, len - 1);
            reverse(arr, i, j);
            // go to the next 2k chars
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
}