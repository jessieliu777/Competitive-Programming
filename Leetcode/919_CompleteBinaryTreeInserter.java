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
class CBTInserter {
    List<TreeNode> tree;

    public CBTInserter(TreeNode root) {
        tree = new ArrayList<>();
        // add the root to the list
        tree.add(root);
        // add all the root's children to the list
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).left != null) tree.add(tree.get(i).left);
            if (tree.get(i).right != null) tree.add(tree.get(i).right);
        }
    }
    
    public int insert(int val) {
        int len = tree.size();
        // construct a new node with the val & add it to the list
        TreeNode node = new TreeNode(val);
        tree.add(node);
        // Node tree[i] has left child tree[2 * i + 1] and tree[2 * i + 2]
        // So reverse the operation we can find tree[i]'s parent by tree[i/2] directly.
        // when there's odd number of nodes i/2 gets rounded down -> its a left child of the parent
        // even nodes -> right child of the parent
        if (len % 2 == 1) tree.get((len - 1) / 2).left = node;
        else tree.get((len - 1) / 2).right = node;
        return tree.get((len - 1) / 2).val;
    }
    
    public TreeNode get_root() {
        return tree.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */