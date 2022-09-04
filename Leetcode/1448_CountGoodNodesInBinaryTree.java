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
    public int goodNodes(TreeNode root) {
        // we just need to check if current node is larger than the largest node in the path. If so, it's good. If not, then it's not good
        return 1 + helper(root.left, root.val) + helper(root.right, root.val);
    }
    public int helper(TreeNode node, int largest) {
        if (node == null) return 0;
        int good = 0;
        if (node.val >= largest) {
            good++;
            largest = node.val;
        }
        good+= helper(node.left,largest) + helper(node.right, largest);
        return good;
    }
}