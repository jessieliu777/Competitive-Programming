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
    public void helper(TreeNode right, TreeNode left, boolean reverse) {
        if (right == null || left == null) return;
        if (reverse) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        } 
        reverse = !reverse;
        helper(right.right, left.left, reverse);
        helper(right.left, left.right, reverse);
    }
    
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root.left == null) return root;
        helper(root.right, root.left, true);
        return root;
    }
}