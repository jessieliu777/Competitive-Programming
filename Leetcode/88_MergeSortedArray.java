class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1, finished = m + n - 1;
        while (index1 >= 0 && index2 >= 0) nums1[finished--] = (nums1[index1] > nums2[index2]) ? nums1[index1--] : nums2[index2--];
        
        // if any nums unadded in nums2, add it to nums1
        while (index2 >= 0) nums1[finished--] = nums2[index2--];
        // if any nums unadded in nums1, leave it cuz it''s already in nums1
    }
}