/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // add every node val to the list
        for (ListNode node = head; node != null; node = node.next) list.add(node.val);
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>(); // push the nodes in order so that they get popped in reversed
        // for every node val in the list
        for (int i = 0; i < list.size(); i++) {
            // when stack is nonempty and the node val where the last index on the stack is less than the node val of cur index, then set the result of the last stack index to be the value of cur index, then pop the last index
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) res[stack.pop()] = list.get(i);
            // add index to the stack
            stack.push(i);
        }
        return res;
    }
}