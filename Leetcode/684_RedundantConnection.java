class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        // given at most 1000 nodes
        parent = new int[1001]; // parent[i] = the 'root' of the component i is connected to
        // initialize every node to be its own parent
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        // for every edge
        for (int[] edge: edges){
            int start = edge[0], end = edge[1];
            // if the nodes at this edge share the same parent, that is they are in the same component then we can remove it
            if (find(start) == find(end)) return edge;
            // otherwise the end edge should be in the same component as start, so denote this by making end the new 'root'
            else parent[find(start)] = find(end);
        }
        return new int[2];
    }
    
    private int find(int node) {
        if (node != parent[node]) parent[node] = find(parent[node]);  
        return parent[node];
    }
}