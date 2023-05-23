class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        // similar to merging k sorted list
        //     ugly number                       k sorted list
        // 1                            2     7    13   19     1 * [2,7,13,19]
        // |                            |     |    |    |
        // 2                            4     14   26   38     2 * [2,7,13,19]
        // |                            |     |    |    |
        // 4                            8     28   52   76     4 * [2,7,13,19]
        // |                            |     |    |    |              
        // 7                            14    49   91   133    7 * [2,7,13,19]
        // |                            |     |    |    |
        // 8                            16    56   ...   ...   8 * [2,7,13,19]
        // |                            |     |    |     |
        // .                            .     .     .    .
        // .                            .     .     .    .
        // .                            .     .     .    .
        
        // use pq to get the list of ugly numbers sorted in order
        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->(a[0]-b[0]));
        // initialize with the queue of the given primes, multiplyer = 1 (multiplier index = 0)
        for (int i=0; i<primes.length; i++) queue.offer(new int[]{primes[i], primes[i], 0});

        // 1 is always ugly regardless of input
        int[] nums=new int[n+1];
        nums[0]=1;
        int i=1;
        while (i<n){
            int[] entry=queue.poll();
            // entry[0] = the actual number
            // entry[1] = the 'base' prime number
            // entry[2] = the index of the 'multiplier' such that nums[index]*base = num
            int num=entry[0], prime=entry[1], index=entry[2];
			// only append non-duplicates
            if (num!=nums[i-1]){
                nums[i]=num;
                i++;
            }
            queue.offer(new int[] {prime*nums[index+1], prime, index+1});
        }
        // after we finish filling out the ugly arr of len n, the last entry is the nth ugly num
        return nums[n-1];
    }
}