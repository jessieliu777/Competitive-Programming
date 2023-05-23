class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        // initialize adj list
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        int minCycle = 1001; // given max nodes is 1000
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n]; // let dist[j] = dist from i to j for
            Arrays.fill(dist, -1);
            dist[i] = 0;

            // do bfs
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int neighbour : adj[cur]) {
                    // if neighbour is unvisited
                    if (dist[neighbour] == -1) {
                        // calculate neighbour distance from i = dist[neighbour]:
                        // distance to neighbour from i = distance from i to cur + distance from cur to neighbour
                        // = distance from i to cur + 1 = dist[cur]+1
                        dist[neighbour] = dist[cur] + 1;
                        queue.offer(neighbour); // try to visit the neigbour next
                    } 
                    // if neighbour is already visited and it's not the starting node i of this path (if we got here then we already got the forward edge from the starting node) and it's not a node with less distance than cur from i (if it has less distance then it could be the pre node that we've already visited on that path, which does not form a cycle, or a future node in the path that forms a cycle that got visited in a different path in the cycle. However, we would get to such path again as backward edge (visiting from i to neighbour on the other side), so do not count it => only count such path once. Since it works outs with edge case only count the path where the neighbour's visited path i to neighbour without cur was longer than the path from i to cur to neighbour')
                    else if (neighbour != i && dist[neighbour] >= dist[cur]) {
                        minCycle = Math.min(minCycle, dist[cur] + dist[neighbour] + 1);
                    }
                }
            }
        }

        return minCycle > 1000 ? -1 : minCycle;
    }
}