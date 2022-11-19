class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        int len = num.length - 1;
        // for every digit
        while (len >= 0 || k != 0) {
            // if there's more digits, add the digit to k
            if (len >= 0) {
                k += num[len];
                len--;
            }
            // add the last digit of k to list
            list.addFirst(k % 10);
            // remove the last digit since we just added
            k /= 10;
        }
        return list;
    }
}