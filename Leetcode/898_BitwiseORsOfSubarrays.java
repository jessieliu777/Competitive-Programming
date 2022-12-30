class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>(); // distinct bitwise ORS of all non-empty subarr
        Set<Integer> cur = new HashSet<>(); // distinct bitwise ORS of one non-empty subarr from prev iteration
        Set<Integer> cur2; // distinct bitwise ORS of one non-empty subarr of cur iteration
        // for each number in the array
        for (Integer num: arr) {
            // create a new set for num, and add it to the set
            cur2 = new HashSet<>();
            cur2.add(num);
            // for every number already added in cur, add the xor of that number and num to cur2. Even though cur already contains the OR'd ones from previous iteration, since OR can only toggle 0 to 1's and not vice versa even if we OR with ones we already did it will be fine
            for (Integer i: cur) cur2.add(num|i);
            // save cur2 in cur, and add it to res
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}