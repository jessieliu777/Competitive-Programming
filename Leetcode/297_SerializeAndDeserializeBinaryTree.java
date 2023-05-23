/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SPLITTER = ",";
    private static final String NULL_VALUE = "x";

    private void buildString(TreeNode node, StringBuilder sb){
        if (node == null) sb.append(NULL_VALUE).append(SPLITTER);
        else {
            sb.append(node.val).append(SPLITTER);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL_VALUE)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(str.split(SPLITTER)));
        return buildTree(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));