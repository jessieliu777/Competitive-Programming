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
    TreeNode prev = null, first = null, second = null;
    private void helper(TreeNode root){
        // do in order traversal -> left node right
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) first = prev;
            // To cover the edge-case of 2 consecutive elements to be swapped, we always assign second = root.
            second = root;
        }
        prev = root;
        helper(root.right);
    }
    public void recoverTree(TreeNode root) {
        helper(root);
        if (first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}