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
    List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at each level;
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 0);
    }

    private int dfs(TreeNode node, int index, int depth) {
        if (node == null) return 0;
        // if depth is higher than the amount of left most nodes we've added then we've yet to add this level's left most node, so add it
        if (depth >= lefts.size()) lefts.add(index);   
        return Math.max(index + 1 - lefts.get(depth), // width of cur level up to cur node is the distance from leftest node to cur node + 1 (since we count width using 'vertices' not 'edges')
                        Math.max(dfs(node.left, index*2, depth+1), // width of cur's left child'
                                dfs(node.right, index*2+1, depth+1))); // width of cur's right child
    }
}