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
class BSTIterator {
    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        // add every left node from root to leftest leaf
        // since added to stack, they should be popped in reverse order, from left to root
        stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }
    
    public int next() {
        // start with the leftest node
        TreeNode node = stack.pop();
        // go in order: node.left (already popped in some prev iteration), node, then node.right
        TreeNode cur = node.right;
        while (cur != null){
            // since left is popped the next in order is cur
            stack.push(cur);
            // move the pointer to the left child of node.right, next iteration will continue in order traversal
            cur = cur.left;
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */