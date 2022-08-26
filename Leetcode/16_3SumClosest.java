class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);
        // use 2 pointers such that 1 starts from start, one starts from end
        int closest = -1; // not a good init for closest but we will always overwrite it by checking smallestDiff
        int smallestDiff = -1;
        // for every potential third number
        for (int i = 0; i < nums.length; i++){
            // assume the target sum is 0-nums[i], so it's similar to 2sum now
            int tempTarget = target-nums[i];
            // do 2 pointers
            int j = 0;
            int k = nums.length-1;
            while (j < k){
                if (j == i) {
                    j++;
                    continue;
                } 
                if (k == i){
                    k--;
                    continue;
                }
                if (nums[j] + nums[k] == tempTarget) return target;
                int tempSum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(target-tempSum);
                if (smallestDiff == -1 || diff < smallestDiff){
                    smallestDiff = diff;
                    closest = tempSum;
                } 
                if (nums[j] + nums[k] < tempTarget){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return closest;
    }
}