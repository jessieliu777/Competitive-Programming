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
    int maxPathValue;
    public int maxPathSum(TreeNode root) {
        maxPathValue = -1000; // given lower bound is -1000
        maxPathDown(root);
        return maxPathValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left)); // the max path if we take the left node
        int right = Math.max(0, maxPathDown(node.right)); // the max path if we take the right node
        // the max path of this node is either the max path so far (Note: by the time we got to this node, the iteration for node.parent is already done. so in that iteration node.parent aleady calculated the optimal node.left, node.right if it was to take the path to this node. Also in this case node is not the root) or the max path in the subtree with node is the root (either just the node itself, or node to one of node.left/right, or node.left -> node -> node.right)
        maxPathValue = Math.max(maxPathValue, left + right + node.val);
        // since path don't allow reusing nodes, if the parent of this node take the path to this node, then from this node it can only continue on to one of node.left and node.right 
        // WLOG node.parent -> node -> node.left takes the left path
        // But if you want to take both WLOG node.parent -> node -> node.left -> node -> node.right, the node would be used twice which isn't allowed as given
        return Math.max(left, right) + node.val;
    }
}