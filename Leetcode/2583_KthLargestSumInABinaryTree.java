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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty())
        {
            int size=qu.size();
            long sum = 0;
            for(int i=0; i < size; i++)
            {
                if(qu.peek().left!=null) qu.offer(qu.peek().left);
                if(qu.peek().right!=null) qu.offer(qu.peek().right);
                sum += (long)qu.poll().val;
            }
            sums.add(sum);
        }
        Collections.sort(sums);
        int sumsSize = sums.size();
        return k > sumsSize ? -1 : sums.get(sumsSize-k);
    }
}