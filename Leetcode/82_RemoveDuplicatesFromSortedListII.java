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
            ListNode temp = cur.next;
            boolean dup = false;
            // keep removing duplicates
            while (temp != null && cur.val == temp.val){
                dup = true;
                cur.next = temp.next;
                temp = temp.next;
            }
            if (dup){
                if (pre != null){
                    pre.next = cur.next;
                } else {
                    head = cur.next;
                }
                
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}