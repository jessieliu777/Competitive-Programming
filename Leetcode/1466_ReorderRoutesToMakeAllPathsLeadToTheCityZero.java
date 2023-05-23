class Solution {
    List<List<Integer>> adj_list;
    boolean[] visited;
    int dfs(int from) {
        int change = 0;
        visited[from] = true;
        // for every edge from root. If the other node at the edge isn't visited then we need to reorder
        // the number of reorders we need from this root to the subgraph starting from that node 
        // = the number of reorders starting from the other node + number of reorders fom root to that node
        // = dfs(Math.abs(to)) + number of reorders for this edge
        // dfs(Math.abs(to)) + (to > 0 ? 1 : 0) [node we want to change all foward edges to bkward,l so reorder this edge iff this edge is forward]
        for (int to : adj_list.get(from)) if (!visited[Math.abs(to)]) change += dfs(Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;   
    }

    public int minReorder(int n, int[][] connections) {
        adj_list = new ArrayList<>();
        visited = new boolean[n];
        // setup adj list
        for(int i = 0; i < n; i++) adj_list.add(new ArrayList<>());
        for (int[] c : connections) {
            // given all pos values, we can denote bkward edge by negative
            // map to pos = forward edge
            // map to neg = bkward edge
            adj_list.get(c[0]).add(c[1]);
            adj_list.get(c[1]).add(-c[0]);
        }
        return dfs(0);
    }
}