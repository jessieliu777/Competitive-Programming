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
    int maxHeight = -1;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root , 0);
        return ans;
    }

    public void dfs(TreeNode node , int height){
        if (node == null) return;
        if (height > maxHeight){
            maxHeight = height;
            ans = node.val;
        }
        dfs(node.left , height+1);
        dfs(node.right , height+1);
    }
}