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
    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        postOrderTraverse(root);
        return maxSum;
    }

    private int[] postOrderTraverse(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}, initialize min=MAX_VALUE, max=MIN_VALUE
        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);
        // no bst :
        if (!(left != null && right != null  // both left and right are nonnull. both null already handled.
                && root.val > left[1]       // the root's key must greater than maximum keys of the left subtree
                && root.val < right[0]))    // the root's key must lower than minimum keys of the right subtree
            return null;
        int sum = root.val + left[2] + right[2]; // now it's a BST make `root` as root
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);
        return new int[]{min, max, sum};
    }
}