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
    int i, p; // i as index for inorder, p as index for preorder
    public TreeNode buildTree(int[] pre, int[] in) {
      i = p = 0;
      return dfs(pre, in, 3001);
    }

    private TreeNode dfs(int[] pre, int[] in, int rightBoundary) {
      if (p == pre.length || in[i] == rightBoundary) return null;
        // preorder goes root left right, so add root first
      TreeNode node = new TreeNode(pre[p++]);
        // after adding root we can move the p pointer
        // preorder goes left after root, so do left next
      node.left  = dfs(pre, in, node.val); // the rightBoundary is the current root since the left subtree shouldn't have any values at or right of current root
      i++;
      node.right = dfs(pre, in, rightBoundary);
      return node;
    }
}