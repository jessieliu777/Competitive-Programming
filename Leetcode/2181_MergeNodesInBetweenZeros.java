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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while ( head != null )
        {
            // if we reached a 0 that's not end
            if ( head.val == 0 && head.next != null ) {
                // then setup for the next merged node
                cur.next = new ListNode(0);
                cur = cur.next;
            }
            // otherwise merge cur val
            else cur.val += head.val;
            head = head.next;
        }
        return dummy.next;
    }
}