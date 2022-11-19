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
    public int maxLevelSum(TreeNode root) {
        int maxSum = -100001;
        int level = 1;
        int result = level;
        // q size = number of nodes in this level
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null){
            q.add(root);
            while (!q.isEmpty()){
                // for every item in the queue
                int nodes = q.size();
                int sum = 0;
                while (nodes > 0){
                    TreeNode node = q.remove();
                    sum += node.val;
                    // add their children to the queue
                    if (node.left != null){
                        q.add(node.left);
                    }
                    if (node.right != null){
                        q.add(node.right);
                    }
                    nodes--;
                }
                if (sum > maxSum){
                    maxSum = sum;
                    result = level;
                }
                level++;
            }
        }
        return result;
    }
}