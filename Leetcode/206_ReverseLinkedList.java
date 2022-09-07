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
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        // use 2 pointers, pre and cur, swap the pointer direction
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode oldNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = oldNext;
        }
        return pre;
    }
}