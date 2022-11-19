class Solution {
    public void sortColors(int[] nums) {
        // count the numbers of 0s and 1s, store them in count0, count1
        int n=nums.length;
        int count0=0;
        int count1=0;
        for(int i=0;i<n;i++) {
            if(nums[i]==0)
                count0++;
            else if(nums[i]==1)
                count1++;
        }
        
        // update the first count0 + count1 to be 0s and 1s respectively, and the remaining of nums are all 2s
        for(int i=0;i<n;i++)
        {
            if(count0>0)
            {
                nums[i]=0;
                count0--;
            }
            else if(count1>0)
            {
                nums[i]=1;
                count1--;
            }
            else nums[i]=2;
        }        
    }
}