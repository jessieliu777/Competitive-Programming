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
    // Find all prime factors of each array element and construct a graph.

    // Construct an undirected graph.
    // Node: Each array element is a node.
    // Edge: If 2 array elements have at least one common prime factor, then we create an edge connecting them.
    // However, constructing the graph directly has higher time complexity. We can find all prime factors of each array element, and put the array element into the corresponding lists according to its prime factors.

    // For example, 60 = 2 ^ 2 * 3 * 5
    // We put 60 in the list of 2, 3, and 5.
    // Now each pair of elements in the same list should have an edge.
    // And the key point here is for each list, we just need to create an edge between the first element and any other elements instead since union find can help us find the 'parent' (first element) plus we only need to make sure they are connected so the num of edges don't matter

    // For example, 3, 15, 60, 99 are in the list of 3.
    // We only need to create edges (3, 15), (3, 60) and (3, 99).

    // The question is to ask whether the graph is connected.
    public boolean canTraverseAllPairs(int[] nums) {
        final int len = nums.length;
        if (len == 1) return true;
        
        // set up union find, and map of prime to first num index where that num is a factor of prime. as mentioned we only need to construct edge from prime to first num because we only need the component to be connected, no need for complete
        UnionFind uf = new UnionFind(len);
        Map<Integer, Integer> primeToFirstNumIndex = new HashMap<>();

        for (int i = 0; i < len; ++i) {
            int num = nums[i];
            if (num == 1) return false;
            
            for (int factor = 2; factor * factor <= num; ++factor) {
                // for factor to be factor, it needs to be divisible by num
                if (num % factor == 0) {
                    // if the 'parent' of cur prime already exist, add cur index to be the child of cur prime via union
                    if (primeToFirstNumIndex.containsKey(factor)) uf.union(i, primeToFirstNumIndex.get(factor));
                    // otherwise cur num is the parent of cur prime
                    else primeToFirstNumIndex.put(factor, i);
                    // since we only want prime factors, 'remove' 'duplicates' of cur factor. for ex if cur factor is 2, remove 4, 6, ... for all factors less than sqrt(num)
                    while (num % factor == 0) num /= factor;
                }
            }

            // if there are any more 'leftovers' after we went through all of cur num's factors that means cur num must not have any factors so it has to be prime
            if (num > 1) {
                // same as before, add cur index to cur num's child if cur num already has parent otherwise make cur index the parent
                if (primeToFirstNumIndex.containsKey(num)) uf.union(i, primeToFirstNumIndex.get(num));
                else primeToFirstNumIndex.put(num, i);
            }
        }
        return uf.getSizeOfComponent(0) == len;
    }
}