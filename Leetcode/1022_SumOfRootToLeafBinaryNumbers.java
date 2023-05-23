/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // decompose this problem into 2 sub-problem:
        // Find all path from root to leaves. DFS recursion should help do that.
        // Transform a path from base to base 10.
        // combine these 2 steps together: adding sum while dfs
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        // in this question if root.left == root.right then both of these nums r the same, so root.left !=root.right for existing val => root.left == root.right == both r null
        return root.left == root.right ? val : dfs(root.left, val) + dfs(root.right, val);
    }
}