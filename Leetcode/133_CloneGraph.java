/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Node helper(Node node, HashMap<Integer,Node> map ) {
        // if we already cloned this node then just return it
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        // clone node
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        // clone neighbours
        for(Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(helper(neighbor, map));
        }
        return clonedNode;
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // maps node val to node, since node val is unique it's 1-1
        HashMap<Integer, Node> map = new HashMap<>();
        return helper(node, map);
    }
}