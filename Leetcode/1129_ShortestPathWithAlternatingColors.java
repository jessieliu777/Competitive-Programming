class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // worst case: theres a path of same colour from 0 to n-1, and each vertex is a self loop. 
        // to alternate, except for 0 and n-1 every other vertex must take the self loop
        // total = len of path of same colour + number of self loops - 0th self loop and n-1st self loop
        // = n-1 (num of edges from 0 to n-1 = num of edges from 1 to n) + n(number of self loops = num of verticies = n) - 1 (0th self loop) - 1(n-1st self loop) = n-1 + n - 1 - 1 = 2n - 3
        
        // Two sets one for blu and another for red
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        // red edges in graph[0], blue in graph[1]
        for (int[] redEdge : redEdges) graph[0][ redEdge[0] ].add(redEdge[1]);
        for (int[] blueEdge : blueEdges) graph[1][ blueEdge[0] ].add(blueEdge[1]);
        
        int[][] res = new int[2][n];
        // initialize result to be 2n since max is 2n-3 as shown above
        for (int i = 1; i < n; i++) {
            res[0][i] = 2 * n;
            res[1][i] = 2 * n;
        }
        // do BFS starting from 0th node
        Queue<int[]> q = new LinkedList<>(); // q[i] = {vertex, colour path to take}
        // try taking the 'neighbour' paths (red edge, blue edge)
        q.offer(new int[] {0, 0}); 
        q.offer(new int[] {0, 1});
        while (!q.isEmpty()) {
            // try to take the current edge
            int[] cur = q.poll();
            int vertex = cur[0];
            int colour = cur[1];
            // since paths have to alternate colour, the next edge has to be alternating colour = 1 - colour
            // for every vertex that connects to the next potential edge
            for (int nxt : graph[1 - colour][vertex]) {
                // if it's not visited (2n is init value and we couldnt have exceeded => res = 2n -> unvisited)
                if (res[1 - colour][nxt] == 2 * n) {
                    // then set it to the length of cur path + 1, and add it to the queue
                    res[1 - colour][nxt] = 1 + res[colour][vertex];
                    q.offer(new int[] {nxt, 1 - colour});
                }
            }
        }
        // after we finish BFS, go through every node and get the min result from starting with red or blue
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Math.min(res[0][i], res[1][i]);
            // note if both red/blue doesn't lead us to a path with alternating colours (result remains 2n => unvisited => no path) then return -1 as req by question
            ans[i] = (t == 2 * n) ? -1 : t;
        }
        return ans;
    }
}