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
    Map<String, Integer> serialToId = new HashMap<>();
    Map<Integer, Integer> idToCount = new HashMap<>();
    int curId = 1;

    private int postorder(TreeNode root, List<TreeNode> res) {
        // if (cur == null) return "#";  
        // String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        // map.put(serial, map.getOrDefault(serial, 0) + 1);
        // if (map.get(serial) == 2) res.add(cur);
        // return serial;
        // The above time complexity is O(n^2). We can improve this to O(n) by replacing full serializations with serial ids instead. Since strings are bring used, the concatenation takes O(n) time in each recursive call taking overall complexity to O(n2).

        if (root == null) return 0;
        // postorder is left, right, root
        int leftId = postorder(root.left, res);
        int rightId = postorder(root.right, res);

        // serialize cur.left, cur, cur.right as string
        String curSerial = leftId + "," + root.val + "," + rightId;
        // check if cur serializer is already stored in map
        int serialId = serialToId.getOrDefault(curSerial, curId);
        // if not, then put the cur id as value. (If so, put the same value back)
        serialToId.put(curSerial, serialId);
        // if the stored id is the cur id then increment id to avoid duplicate id. If not, then can still use the cur id for the next potential value
        if (serialId == curId) curId++;
        // increment the value of count of this id
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        // if there's exactly 2 then we are done
        // don't add more than 2 cuz we've already added for 2 so don't make duplicates

        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }
}