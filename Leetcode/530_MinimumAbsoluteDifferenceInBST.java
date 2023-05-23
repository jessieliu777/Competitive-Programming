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
    int min = Integer.MAX_VALUE;
    Integer leftNeighbour = null;

    public int getMinimumDifference(TreeNode root) {
        // given BST, in order traversal guarentees ascending order, so just compare the adj nodes via in order
        if (root == null) return min;
        getMinimumDifference(root.left);
        // given BST and we are doing in order, root.val > prev so root.val - prev > 0 => no need for abs difference
        if (leftNeighbour != null) min = Math.min(min, root.val - leftNeighbour);
        leftNeighbour = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}