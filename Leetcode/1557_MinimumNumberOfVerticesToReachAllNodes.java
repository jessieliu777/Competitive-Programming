class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        // Just return the nodes with no in-degres.

        // Quick prove:

        // Necesssary condition: All nodes with no in-degree must in the final result,
        // because they can not be reached from
        // All other nodes can be reached from any other nodes.

        // Sufficient condition: All other nodes can be reached from some other nodes.

        List<Integer> res = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (List<Integer> e: edges) seen[e.get(1)] = true;
        for (int i = 0; i < n; ++i) if (!seen[i]) res.add(i);
        return res;
    }
}