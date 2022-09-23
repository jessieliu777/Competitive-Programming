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
    public int helper(TreeNode node, int path){
        int count = 0;
        if (node == null) return 0;
        // keep the frequency of digit i in the ith bit --> path = path ^ 1 << node.val
        // xor of 0 and 1 results in 1, xor in 2 equal bits result in zero --> bit is 1 only if it appears odd number of times
        path = path ^ (1 << node.val);
        // if it's a leaf node, then we can check the whole path
        if (node.left == null && node.right == null){
            // to check if the digit have at most 1 nonzero bit, check that path is a power of 2 --> path & (path-1) == 0
            if ((path & (path-1)) == 0){
                count++;
            }
        } else {
            count += helper(node.left, path) + helper(node.right, path);
        }
        return count;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        // a path is pseudo palindromic if it has at most 1 digit that occurs odd number of times
        // traverse the tree in pre order to get all the paths
        return helper(root, 0);
    }
}