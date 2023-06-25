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
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        // get number of coins to distribute of left tree and right tree
        int left = dfs(root.left), right = dfs(root.right);
        // get the number of operations. the min number is moving them to root or from root (if it needs to receive instead of giveaway), so even tho receive and giveaway are represented via different signs, the magnitude is the operation count
        res += Math.abs(left) + Math.abs(right);
        // number of coins to distribute from tree rooted at root is the cur number of coins - 1 (keep 1 coin to itself, give away the rest) + coins to distribute from left subtree + coins to distribute from right subtree. Note if it has 0 coins, the number of coins to distribute is -1 as in it should receive a coin instead of giveaway
        return root.val-1 + left + right;
    }
}