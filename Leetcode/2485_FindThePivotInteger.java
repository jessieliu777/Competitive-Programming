class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n+1) /2;
        int ksum=0;
        for(int i=1;i<=n;i++)
        {
            ksum+=i;
            if(ksum==sum)
            {
                return i;
            }
            sum-=i;
        }
        return -1;
    }
}