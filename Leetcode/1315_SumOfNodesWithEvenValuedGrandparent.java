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
    public int sumEvenGrandparent(TreeNode root) {
        // Let children know who their grandparent is.
        // initialize root with dummy parent.val = 1 and grandparent.val = 1. Since we only care about even grandparents it doesn't affect the result as we set it to be odd
        // Recursive iterate the whole tree and pass on the value of parent and grandparent.
        // Count the node.val when grandparant is even-valued.
        return helper(root, 1, 1);
    }

    private int helper(TreeNode node, int parent, int grandparent) {
        if (node == null) return 0;
        return helper(node.left, node.val, parent) + helper(node.right, node.val, parent) + (grandparent % 2 == 0 ? node.val : 0);
    }
}