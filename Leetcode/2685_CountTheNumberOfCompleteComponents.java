class Solution {
    class UnionFind {
        private int[] parent, size;
        private int count;
        
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }

        }
        
        public int find(int p) {
            // path compression
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) 
                return;
            // union by size
            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
        
        public int count() { return count; }

        public int getSizeOfComponent(int c){
            return size[find(c)];
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        Set<Integer> completeComponents = new HashSet<>();
        int[] degrees = new int[n];
        // set up degrees agree st degrees[i] = the degree of node i
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
            degrees[e[0]]++; 
            degrees[e[1]]++;
        }

        // add the 'root' of each node's component
        for (int i = 0; i < n; i++) completeComponents.add(uf.find(i));

        for (int i = 0; i < n; i++)
            if (uf.getSizeOfComponent(i) != degrees[i] + 1)
                completeComponents.remove(uf.find(i));

        return completeComponents.size();
    }
}