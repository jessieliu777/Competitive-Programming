class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        int ns = newInterval[0], ne = newInterval[1], i = 0;
        // add all the intervals that ends earlier than newInterval starts
        while (i < intervals.length && intervals[i][1] < ns) ret.add(intervals[i++]);
        // for all the intervals that ends after newInterval starts (already skipped the ones that ends earlier) and starts before newInterval ends, we need to merge
        while (i < intervals.length && ne >= intervals[i][0]) {
            ns = Math.min(ns, intervals[i][0]);
            ne = Math.max(ne, intervals[i++][1]);
        }
        ret.add(new int[]{ns, ne});
        while (i < intervals.length) ret.add(intervals[i++]);
		return ret.toArray(new int[0][]);
    }
}