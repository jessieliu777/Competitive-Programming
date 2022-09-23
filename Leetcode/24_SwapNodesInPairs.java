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
    public ListNode swapPairs(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            // if cur.next is not null, we have to swap, otherwise we are done
            if (temp != null){
                cur.next = temp.next;
                temp.next = cur;
                if (pre != null){
                    pre.next = temp;
                } else {
                    head = temp;
                }
                pre = cur;
                cur = cur.next;
                
            } else {
                cur = null;
            }
        }
        return head;
    }
}