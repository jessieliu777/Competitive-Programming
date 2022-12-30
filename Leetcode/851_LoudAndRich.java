class Solution {
    HashMap<Integer, List<Integer>> richer2 = new HashMap<>();
    int res[];

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        // initializer everyone's list of people who's louder
        for (int i = 0; i < n; ++i) richer2.put(i, new ArrayList<Integer>());
        // map everyone to the list of people louder than them
        for (int[] v : richer) richer2.get(v[1]).add(v[0]);

        res = new int[n]; Arrays.fill(res, -1);
        // for every person get the least quiet person among the ones who are richer than them
        for (int i = 0; i < n; i++) dfs(i, quiet);
        return res;
    }

    int dfs(int i, int[] quiet) {
        // if we already found that person the just return it
        if (res[i] >= 0) return res[i];
        // initialize that person to be i
        res[i] = i;
        // for everyone j louder than i, if the current result is quieter than the volume of (the loudest person among the people richer than j), then change res[i] to res[j] since we want the louder person
        for (int j : richer2.get(i)) if (quiet[res[i]] > quiet[dfs(j, quiet)]) res[i] = res[j];
        return res[i];
    }
}