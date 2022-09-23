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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // q size = number of nodes in this level
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null){
            q.add(root);
            while (!q.isEmpty()){
                // for every item in the queue
                int nodes = q.size();
                List<Integer> resultLevel = new ArrayList<>();
                while (nodes > 0){
                    TreeNode node = q.remove();
                    resultLevel.add(node.val);
                    // add their children to the queue
                    if (node.left != null){
                        q.add(node.left);
                    }
                    if (node.right != null){
                        q.add(node.right);
                    }
                    nodes--;
                }
                result.add(resultLevel);
            }
        }
        return result;
    }
}