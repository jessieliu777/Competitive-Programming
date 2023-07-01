class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        // This is a variation of a very classic problem: There are some ants on a plank at some positions. They are moving right or left, and change directions when they bump into each other. When does the last ant fall off the plank?
        // At first glance, this may seem difficult to compute, as many collisions may be happening and it is hard to keep track of them all. But there is a very important key observation here: When two ants bump into each other, we can just act like they "phased" through each other! When one ant is going left, and another is going right, and they bump into each other, the left ant is now going right and the right ant is going left. There would be no difference if we had just swapped the ants, or let them pass through each other.

        // We can now apply this idea to the robots. Let us ignore any collisions, and just imagine all robots simply passed through each other, as if they were ghosts. Then now we can simply just subtract the distance from them if they were going left or add the distance to them if they were going right. Now, we simply need to compute the distance between each pair of robots. Note that (i, j) and (j,i) should not both be counted, so we will only use a prefix sum. If (j,i) was meant to be counted, we would use a prefix and postfix sum. We can compute this easily by sorting the array, then multiplying the number times the index, minus the prefix sum. This gives us the distance between all pairs of robots without double counting.
        
        long ans=0, n=s.length(), mod=(long)1e9+7;
        // simulate all iterations
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='R') nums[i]+=d;
            else nums[i] -= d;
        } 
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
        // prefix sum can actually be replaced by the code below 

        // lets say we have to compute the answer for this array [a, b, c, d]
        // so distance b/w each pair 
        // = b-a + c-a + d-a + c-b + d-b + d-c 
        // = -3a + b - 2b + 2c - c + 3d
        // = (0a - 3a) + (b - 2b) + (2c - c) + (3d - 0d)
            ans = (ans+ i*(long)nums[i] - (n-i-1)*nums[(int)i]) % mod;
        }
        return (int)ans;
    }
}