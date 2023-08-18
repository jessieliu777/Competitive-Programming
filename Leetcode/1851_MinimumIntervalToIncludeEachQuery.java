class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashMap<Integer, Integer> res = new HashMap<>();
        int i = 0, intervalsLen = intervals.length, queriesLen = queries.length;
        int[] queriesSorted = queries.clone(), res2 = new int[queriesLen];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0] , b[0]));
        Arrays.sort(queriesSorted);

        // go through each query from smallest to biggest
        for (int query : queriesSorted) {
            // for all the intervals that starts before query, put its key as size, value as end in treemap
            while (i < intervalsLen && intervals[i][0] <= query) {
                int l = intervals[i][0], r = intervals[i++][1];
                map.put(r - l + 1, r);
            }
            // for all the entries before the first interval that contains query, if that end is before query, the interval doesn't contain query so skip
            while (!map.isEmpty() && map.firstEntry().getValue() < query) map.pollFirstEntry();
            // if map doesn't contain query, result is -1, otherrwise result is the size of the interval
            res.put(query, map.isEmpty() ? -1 : map.firstKey());
        }
        i = 0;
        for (int q : queries) res2[i++] = res.get(q);
        return res2;
    }
}