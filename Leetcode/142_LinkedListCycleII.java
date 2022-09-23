/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode cur1 = head; // traverse 1 node at a time
        ListNode cur2 = head; // traverse 2 nodes at a time
        ListNode target = head;
        
        while (cur2 != null && cur2.next != null) {
            cur2 = cur2.next.next;
            cur1 = cur1.next;
            // found cycle
            if (cur2 == cur1) {
                while (target != cur1) {
                    cur1= cur1.next;
                    target = target.next;
                }
                return target;
            }
        }
        return null;
    }
}