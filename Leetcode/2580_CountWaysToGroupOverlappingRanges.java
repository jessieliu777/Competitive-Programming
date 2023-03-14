class Solution {
    public int countWays(int[][] ranges) {
        int res = 1, endGroup = -1, mod = (int)1e9 + 7;
        // sort by start time
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        for (int[] r: ranges) {
            // if the curent end time of cur the group is less than the start time of cur range, then the cur range has nothing overlap with the ranges so far, so it must be in a new group
            // we can put the group so far in group1 and the new group in group2, or vice versa.
            // so total number of ways = 2*(ways to split old group * ways to split new group)
            // = 2 * res * 1 = 2 * res
            // do mod 10^9 + 7 since question said to
            if (endGroup < r[0]) res = 2 * res % mod;
            // update the new end time of the group
            // if the cur range is in cur the group, then we take the max time of prev end time, and r[1]
            // o/w the cur range is not in the group, then we need to make a new group with cur range, so the new group's end time is r[1]. If cur range isn't in group then there's no overlap so r[1] > endGroup.
            // so Math.max(endGroup, r[1]) works in both cases
            endGroup = Math.max(endGroup, r[1]);
        }
        return res;
    }
}