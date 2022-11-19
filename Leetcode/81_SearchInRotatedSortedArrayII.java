class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        
        while(start <= end) {
            int mid = start + (end - start) /2;
            if(target == nums[mid]) return true;
            // if the middle number is greater than the start number
            if(nums[start] < nums[mid]) {
                // target is between start and mid then move end to before mid
                if(nums[start] <= target && target < nums[mid] ) end = mid -1; 
                // if not then move start to after mid
                else start = mid +1;
            } 
            // if the middle number is less than the start number then it's rotated
            else if (nums[start] > nums[mid]){
                // if target is between mid and end then move start to after mid
                if(nums[mid] < target && target <= nums[end] ) start = mid +1;
                // if not then move end to before mid
                else end = mid-1;
            } 
            // if middle number is equal to the start number
            else {
                start++;
            }
        }
        return false;
    }
}