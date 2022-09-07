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
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        // remove all the subtrees without 1's
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // if any subtrees remain that means they contain 1, so since it's contained in root, then root contains 1 too
        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }
        return root;
    }
}