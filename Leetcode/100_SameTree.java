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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;
        if (p != null){
            // if p q both not null
            if (q != null){
                result = p.val == q.val ? true: false;
                result = result && isSameTree (p.left, q.left) && isSameTree(p.right, q.right);
            }
            else {
                result = false;
            };
        } else {
            // if p is null, q has to be null to be true
            result = (q == null);
        }
        
        return result;
    }
}