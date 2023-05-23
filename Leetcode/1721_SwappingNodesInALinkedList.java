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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        for (var cur = head; cur != null; cur = cur.next) {
            // for every iteration, move n2 pointer forward if it's not null
            n2 = n2 == null ? null : n2.next;
            // decrement k every iteration, if it reaches 0 then cur is the kth node forward
            if (--k == 0) {
                n1 = cur;
                // set n2 to be the head when we found the kth node. Then it'll take n-k iteration to reach the end of the node if there's n nodes in total
                // after n-k iteration, n2 will arrive at the kth node from the end
                n2 = head;
            }
        }
        // The problem description specifically asks to swap values, not nodes themselves. 
        var tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }
}