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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;
        if (left == right) return head;
        int index = 1;
        ListNode pre = null;
        ListNode cur = head;
        ListNode leftNode = null;
        ListNode leftPre = null;
        ListNode rightNode = null;
        ListNode rightNxt = null;
        while (cur != null){
            // when we find the starting index, start reversing
            if (index == left){
                leftPre = pre; // store the node before left
                leftNode = cur;
                while (index <= right){
                    ListNode temp = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = temp;
                    index++;
                }
                rightNode = pre;
                rightNxt = cur; // store the node after right
            } 
            // otherwise keep going until we find left
            else {
                pre = cur;
                cur = cur.next;
                index++;
            }
        }
        if (leftPre != null){
            leftPre.next = rightNode;
        } else {
            head = rightNode;
        }
        leftNode.next = rightNxt;
        return head;
    }
}