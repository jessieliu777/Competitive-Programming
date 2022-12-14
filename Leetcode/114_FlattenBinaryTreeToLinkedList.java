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
    public void flatten(TreeNode root) {
        while (root != null) {
            // flatten the left before the right
            if (root.left != null) {
                TreeNode prev = root.left;
				
				// Find the rightmost node in left subtree
                while (prev.right != null)
                    prev = prev.right;
                
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            
            root = root.right;
        }
    }
}