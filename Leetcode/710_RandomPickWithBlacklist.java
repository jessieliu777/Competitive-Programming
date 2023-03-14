class Solution {
    Random random;
    int len = 0;
    Map<Integer, Integer> map;
    public Solution(int n, int[] blacklist) {
        // initialize map where the key is all blacklist nums
        map = new HashMap<>();
        for (int num: blacklist) map.put(num, -1);
        len = n-blacklist.length;
        // need an arr such that all the non-blacklist nums is before black-list nums, can achieve by
        // re-mapping every black list num to the last non-black list & non-mapped member of the list
        // ex: n=10, blacklist=[3, 5, 8, 9], re-map 3 and 5 to 7 and 6.
        // map = {3: 7, 5: 6} (don't need to remap 8, 9 since they are in the right spot)
        // iteration 0: 0th black list num is 3. Traversing bkwards, skip over 9, 8 since they are in the black list. 7 is the next non-mapped non-blacklist num, so map 3: 7
        // iteration 1: continue from where we left off. We stopped at 7, now keep going to 6. 6 is non-mapped non-blacklist, so Map 5 to 6
        for (int b : blacklist) {
            // given there's only len amount non-lacklist ones we can only remap up to len times. so no need to go past len. The nums at least len would be 'already sorted'
            if (b < len) { 
                // skip the blacklist ones
                while (map.containsKey(n - 1)) n--;
                map.put(b, n - 1);
                n--;
            }
        }
        random = new Random();
    }
    
    public int pick() {
        // Instance of random class
        int num = random.nextInt(len);
        // if the picked num is blacklisted then get the 'mapped' non-blacklist number
        return map.getOrDefault(num, num);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */