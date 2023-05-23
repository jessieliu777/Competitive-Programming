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
    int len;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        // longest path with each val = node.val starting from node -> node.left -> ...
        int left = getLen(node.left, node.val); 
        // longest path with each val = node.val starting from node -> node.right -> ...
        int right = getLen(node.right, node.val); 
        // update len if it's optimal than before. Cur len is number of edges from ... -> node.left -> node -> node.right 
        // = number of edges from ... -> node.left -> node + number of edges from node -> node.right -> ..
        // = left + right
        len = Math.max(len, left + right);
        // if cur val is the val that got passed then return the longest path that passes through cur node
        // since it's to be returned to the parent node's iteration, we can only pick one of left or right path of cur node (otherwise if we want to take both and reach parent then node must be visited twice which isn't allowed'), + 1 is to include the edge of this node's
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }
}