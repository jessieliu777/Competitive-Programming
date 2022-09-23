class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int minJumps = 0;
        int maxIndicesInCurJump = 0; // includes all indicies already jumped. For example maxIndicesInAJump at index i is nums[i] + indices jumped = nums[i] + i
        // we don't need to jump from the last element
        int indicesLeftInCurJump = 0; // how many indices left to complete current jump
        for (int i = 0; i < nums.length-1; i++){
            maxIndicesInCurJump = Math.max(maxIndicesInCurJump, nums[i] + i);
            // jump one index, and if we jumped through all the indices
            if (--indicesLeftInCurJump <= 0){
                // update it to be the next max amount we have to jump
                indicesLeftInCurJump = maxIndicesInCurJump-i;
                minJumps++;
            }
        }
        return minJumps;
    }
}