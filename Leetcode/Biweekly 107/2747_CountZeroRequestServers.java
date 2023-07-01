class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        // sort server by time
        Arrays.sort(logs, Comparator.comparingInt(log -> log[1]));
        int qlen = queries.length, logsLen = logs.length;
        int used = 0; // number of used (unique) server
        int[] cnt = new int[n + 1]; // the number of requests in the sliding window
        int[] res = new int[qlen]; 
        // get the orig indices of sorted queries
        var ids = IntStream.range(0, qlen).boxed().sorted(Comparator.comparingInt(a -> queries[a])).toList();
        // go through every query in sorted order. Use sliding window [j, i]
        // since everything is sorted now, we don't need to recalculate stuff that's calculated in pre iteration. 
        // case 1: request included per iteration and still included cur iteration => used count doesn't change
        // case 2: request included per iteration but excluded cur iteration => used count doesn't change => simply exclude the request, if that's enough to bring the request count of the server to 0 then the server hasn't been used in cur time - x, time, so that would reduce used count by 1 as wanted. 
        // case 3, 4 for request excluded pre iteration is similar to above.
        int i = 0, j = 0;
        for (int id : ids) {
            // include logs with lesser or equal query time cur time (queries[id])
            // used count increases if the number of requests including cur is exatly 1 (a new server we encountered)
            for (; i < logsLen && logs[i][1] <= queries[id]; ++i) used += (++cnt[logs[i][0]] == 1) ? 1 : 0;
            // exclude logs before cur time (queries[id]) - x so we end up with number of logs between cur time-x and cur time inclusive
            // used count decreases if the number of requests including cur is exactly 0 (after excluding new server we encountered => as a net result did not encounter)
            for (; j < logsLen && logs[j][1] < queries[id] - x; ++j) used -= (--cnt[logs[j][0]] == 0) ? 1 : 0;
            // so we should be getting used = number of requests used, so to get the number of server not used it's n - used
            res[id] = n - used;
        }
        return res;
    }
}