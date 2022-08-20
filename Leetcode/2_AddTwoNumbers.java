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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode result = null;
        ListNode cur = result;
        int carry = 0;
        // while we can continue
        while (cur1 != null || cur2 != null || carry > 0){
            int sum = 0;
            sum += carry;
            if (cur1 != null){
                sum += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null){
                sum += cur2.val;
                cur2 = cur2.next;
            }
            int digit = sum % 10;
            carry = sum/10;
            ListNode nxt = new ListNode(digit);
            if (cur != null){
                cur.next = nxt;
            } else {
                result = nxt;
            }
            // move to next iteration
            cur = nxt;
        }
        return result;
    }
}