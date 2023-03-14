class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int num = 1;
        // find the first power of 2 that's not in nums. 
        // any non-power of 2 numbers can be expressed by using the powers of 2 that's less than the upcoming power of 2, so no need to check those
        // for example
        // if 2^0 = 1 is not in nums then return 1. If not, then we can use 1 to OR some other num. 
        // if 2^1 = 2 is not in nums then return 2. If not, then use 2 | 1 (both of them have to be in nums cuz otherwise it would've returned by now) to get 3 => 3 is expressible
        // doesn't matter if 3 is in nums or not since it's expressible. Move on to 2^2 = 4. If 2^2 is not in nums then return 4. If not, then we can use 4 | 1 to express 5 => 5 is expressible. We can use 4 | 2 to express 6 => 6 is experssible. We can use 4 | 2 | 1 to express 7 => 7 is expressible
        // similar to 3, since 5, 6, 7 are expressible, no point of checking if they are in nums. Same as before, move on to 2^3 = 8. Similar to before, all the numbers 8 < x < 16 can be expressed by ORing some subset of 1, 2, 4, 8. Then we only need to check 16, then after 16 is 32, 64, etc.
        while (set.contains(num)) num <<= 1;
        return num;
    }
}