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
    
    public List<Integer> preorder(Node root) {
        List<Integer> out = new ArrayList<>();
        if (root != null){
            out.add(root.val);
            int i = 0;
            while (i < root.children.size() && root.children.get(i) != null){
                out.addAll(preorder(root.children.get(i)));
                i++;
            }
        }
        return out;
    }
}