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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // Base case...
        // If the subtree is empty i.e. root is NULL, return depth as 0...
        if(root == null)  return 0;
        
        // If the both subtrees are empty
        if(root.left == null && root.right == null)
            return 1;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // If the left subtree is empty, return the depth of right subtree, same for right
        if(root.left == null)
            return 1 + rightDepth;
        if(root.right == null)
            return 1 + leftDepth;
        // when both nonempty, return the min depth
        return Math.min(leftDepth, rightDepth) + 1;
    }
}