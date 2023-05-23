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
    public int findSecondMinimumValue(TreeNode root) {
        // given left is null iff right is null
        if(root.left == null) return -1;
        // given root.val = min(root.left.val, root.right.val) always holds
        // root must be the min
        // if child node of root is the same, then the potential second min must be this child's children
        // if the child node of the root is diff, given root is at most the child value, this child must be greater than root, so it is the second min
        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
        // if there's no second min for at least one child, then take the max as at least one of them is -1, the other one is potentially a natural number. if it's also -1, then there's no second min so return -1 as wanted.
        // if there is a second min for both then return the smallest one since we want the min
        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
    }
}