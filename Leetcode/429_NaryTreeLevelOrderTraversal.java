/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        // q size = number of nodes in this level
        Queue<Node> q = new LinkedList<>();
        if (root != null){
            q.add(root);
            while (!q.isEmpty()){
                // for every item in the queue
                int nodes = q.size();
                List<Integer> resultLevel = new ArrayList<>();
                while (nodes > 0){
                    Node node = q.remove();
                    resultLevel.add(node.val);
                    // add their children to the queue
                    for (Node child: node.children){
                        q.add(child);
                    }
                    nodes--;
                }
                result.add(resultLevel);
            }
        }
        return result;
    }
}