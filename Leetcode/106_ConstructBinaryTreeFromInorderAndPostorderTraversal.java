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
 *     }/**
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
    int i, p; // i as index for inorder, p as index for postorder
    public TreeNode buildTree(int[] in, int[] post) {
        i = p = in.length-1;
        return dfs(post, in, -3001);
    }

    private TreeNode dfs(int[] post, int[] in, int leftBoundary) {
        if (p < 0 || in[i] == leftBoundary) return null;
        // post order goes left right root, so by traversing backwords we do root right left
        TreeNode node = new TreeNode(post[p--]);
        node.right = dfs(post, in, node.val);
        i--;
        node.left = dfs(post, in, leftBoundary);
        return node;
    }
}