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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nth = head;
        ListNode none = new ListNode();
        ListNode nthfromend = none;
        none.next = head;
        
        // get the nth node
        for (int i = 0; i < n && nth != null; i++){
            nth = nth.next;
        }
        
        // both 0th and nth node iterates len-n times
        while (nth != null){
            nth = nth.next;
            nthfromend = nthfromend.next;
        }
        if (nthfromend != null){
            if (nthfromend.next != null){
                nthfromend.next = nthfromend.next.next;
            }
        }
        return none.next;
    }
}