class Solution {
    public boolean isValidSerialization(String preorder) {
        // In a binary tree, if we consider null as leaves, then

        // all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root which has 2 outdegrees 0 indegree
        // all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

        // While attempting to 'build' the tree, record the difference between out degree and in degree 
        // diff = outdegree - indegree. 

        // When the next node comes, we then decrease diff by 1, because the node provides an in degree except for root (since indegree is counted as 1 for every other node, simply pad an extra +1 for initializing diff to cancel out the extra indegree)
        // If the node is not null, we increase diff by 2, because it provides two out degrees. (so in total diff for non null is -1+2 = +1)
        // If a serialization is correct, diff should never be negative and diff will be zero when finished.
        String[] nodes = preorder.split(",");
        int diff = 1; // init diff to be 1 since we decrement indegree for every node except root, so need the +1 to cancel out the unnecessary indegree of root as root has no indegree
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}