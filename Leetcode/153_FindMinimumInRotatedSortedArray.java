class Solution {
    public int findMin(int[] nums) {
        int k=nums[0],i=0,j=nums.length-1;
        // for ex [0, 1, 2, 3, 4, 5, 6, 7]
        // if it's rotated the 0 must not be the first element. so when nums[0] < last element then it must be non rotated, so min is first element
        if(nums[i]<=nums[j]) return nums[i];
        while(i!=j){
            // if k is greater then middle element then move right pointer to middle element
            if(k>nums[(i+j)/2]) j = (i+j)/2;
            // if k is at most the middle element
            else if(k<=nums[(i+j)/2]){
                // if the middle element is greater than its right, then the right is the rotated 'slice', so return the right element
                if(nums[(i+j)/2]>nums[(i+j)/2+1]) return nums[(i+j)/2+1];
                // other wise update k to be the middle element, and move the left pointer to the middle index
                k=nums[(i+j)/2];
                i=(i+j)/2;
            }
        }
        return nums[(i+j)/2];
    }
}