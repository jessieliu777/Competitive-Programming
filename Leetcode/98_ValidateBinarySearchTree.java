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
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }

        boolean result = isValid(root.left, Long.MIN_VALUE, root.val) && isValid(root.right, root.val, Long.MAX_VALUE);
        return result;
    }
    
    public boolean isValid(TreeNode root, long low, long high){
        if (root == null){
            return true;
        }
        boolean result = high > root.val && low < root.val;
        result = result && isValid(root.left, low, root.val) && isValid(root.right, root.val, high);
        return result;
    }
}