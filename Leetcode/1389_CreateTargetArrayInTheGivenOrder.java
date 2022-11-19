class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {        
        int[] target = new int[nums.length];
        // for every index
        for(int i = 0; i < index.length; i++){
            int ind = index[i];
            // if index value is less than index's index, then the target 'length' is supposed to be increased, so we need to shift the target to make space for the new inserted number
            if(ind < i){
                // shift all the items after where we need to insert in target one right
                int j = i;
                while(ind < j){
                    target[j] = target[j - 1]; 
                    target[j - 1] = nums[i];
                    j--;
                }
            }
            // otherwise if the index we need to insert is the last element, then no need to shift since it can't be occupied as given in the question all operations are valid (so we won't be getting an index that's not adjacent to any numbers in the ones we've inserted so far).
            else{
                 target[i] = nums[ind];
            }
            
        }
        return target;
    }
}