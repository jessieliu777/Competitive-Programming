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
    public TreeNode recoverFromPreorder(String traversal) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>(); // the nodes in the stack should be (popped order) from parent of cur node to root
        int len = traversal.length();
        for (int i = 0; i < len;) {
            // level = num of dashes
            for (level = 0; traversal.charAt(i) == '-'; i++) level++;
            // value = int(the digits concatenated)
            for (val = 0; i < len && traversal.charAt(i) != '-'; i++) val = val * 10 + (traversal.charAt(i) - '0');
            
            // construct a new node for cur val
            TreeNode node = new TreeNode(val);
            
            // since stack should be nodes from parent of cur node to root, the amount should be 'level' number of nodes. excess nodes can happen when another leaf node was reached in prev iteration, so remove any excess 'paths' that doesn't lead to cur node. Since order of stack is from root to parent node, and that should contain exactly level amount (the num of nodes in a path is len of path (level) + 1, but the + 1 is cur node, so the num of nodes in the path must be level amount of nodes)
            // ex: 1
            // 2       5
            //3 4     6  7
            // stack is [1, 2, 3] when cur node reaches 4. but the stack should be th path [1, 2, 4], so we need to remove any 'excess' nodes which is any node after the level-th node, in this case is just after 2nd node, 3. After removing 3, stack becomes [1, 2]. After operation, add cur node to stack so it becomes [1, 2, 4]. Now next iter cur node becomes 5, and 5 is on level 1, so remove any node after the 1st node, which is 2, 4. Stack becomes [1, 5], and so on.
            while (stack.size() > level) stack.pop();
            // latest node in stack is the parent of cur node, and given if parent only has one child it has to be left, try to assign cur node as left child first. If left is already occupied, assign as right child
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) stack.peek().left = node;
                else stack.peek().right = node;
            }
            stack.add(node);
        }
        // after building the tree, remove every node in the stack except the root as the root is all we need to return
        while (stack.size() > 1) stack.pop();
        return stack.pop();
    }
}