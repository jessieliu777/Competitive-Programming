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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            if (pre == null){
                pre = cur;
                cur = cur.next;
            } else {
                // if duplicate
                if (pre.val == cur.val){
                    pre.next = cur.next;
                    cur.next = null;
                    cur = pre.next;
                } else {
                    pre = cur;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}