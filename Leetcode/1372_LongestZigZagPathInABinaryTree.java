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
    private int[] dfs(TreeNode root) {
        // initialized all values to -1 for null so that a single node would get the +1 to cancel out to have a length of 0 as wanted
        if (root == null) return new int[]{-1, -1, -1};
        int[] left = dfs(root.left), right = dfs(root.right);
        // Recursive return [left, right, result], where:
        // left is the maximum length in direction of root.left inclusive of root
        // right is the maximum length in direction of root.right inclusive of root
        // result is the maximum length in the whole sub tree may or may not include root

        // now cur node's max length by taking left node is length of cur node to left + max length of left going right (given need to flip)
        // so left node max len = 1 + left[1]
        // similarly, cur node's max length by taking right node is 1 + right[0]
        int maxLeft = left[1] + 1;
        int maxRight = right[0] + 1;
        // max result is the highest length out of the path by including the root, or excluding (or not) the root. In the case the root is included, the result has to be the highest out of maxLeft and maxRight. Otherwise, it takes on the highest result value from the children, which is stored in left[2], right[2]
        int res = Math.max(Math.max(maxLeft, maxRight), Math.max(left[2], right[2]));
        
        return new int[]{maxLeft, maxRight, res};
    }

    public int longestZigZag(TreeNode root) {
        return dfs(root)[2];
    }
}