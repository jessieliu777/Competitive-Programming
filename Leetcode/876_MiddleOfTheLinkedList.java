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
    public ListNode middleNode(ListNode head) {
        /// get the size of linkedlist
        ListNode cur = head;
        int size = 0;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        int middle = size/2;
        // reset cur
        cur = head;
        int index = 0;
        while (cur != null){
            if (index == middle){
                return cur;
            }
            cur = cur.next;
            index++;
        }
        return null;
    }
}