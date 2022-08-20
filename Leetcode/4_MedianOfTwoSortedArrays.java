class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double med = 0.0;
        
        int[] result = merge(nums1, nums2);
        int middle = (int) (result.length/2);
        if (result.length % 2 == 0){
            med = (result[middle] + result[middle-1])/2.0;
        } else {
            med = result[middle];
        }
        return med;
    }
    
    public int[] merge(int[] nums1, int[] nums2){
        int[] temp = new int[1];
        int[] result = new int[nums1.length+nums2.length];
        if (nums1.length == 0){
            return nums2;
        } else if (nums2.length == 0){
            return nums1;
        } else {
            int[] nxt;
            if (nums1[0] < nums2[0]){
                temp[0] = nums1[0];
                nxt = merge(Arrays.copyOfRange(nums1, 1, nums1.length), nums2);
            } else {
                temp[0] = nums2[0];
                nxt = merge(nums1, Arrays.copyOfRange(nums2, 1, nums2.length));
            }
            System.arraycopy( temp, 0, result, 0, temp.length);
            System.arraycopy( nxt, 0, result, temp.length, nxt.length );
        }
        return result;
    }
}