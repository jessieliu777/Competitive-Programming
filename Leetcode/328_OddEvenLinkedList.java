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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode evenCur = evenHead;
        ListNode oddCur = head;
        // odd = 1 -> even = oddCur.next = 2 -> even.next = 3
        while (evenCur != null && evenCur.next != null){
            // oddCur = 1 -> oddCur.next = even.next = 3 
            oddCur.next = evenCur.next; // point odd to the next odd
            // oddCur = 3
            oddCur = oddCur.next;
            // even = 2 -> oddCur.next = 4
            evenCur.next = oddCur.next;
            // even = 4
            evenCur = evenCur.next;
        }
        oddCur.next = evenHead;
        return head;
    }
}