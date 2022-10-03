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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // want to get from 1->2 ... k -> reversed(k+1) to k -> ... -> 2 -> 1 -> reversed(k+1)
            while (count-- > 0) { // reverse current k-group
                ListNode tmp = head.next; // 1 -> 2 => head = 1, tmp = 2
                head.next = curr; // 1 -> k+1
                curr = head; // cur = 1
                head = tmp; // head = 2
            }
            head = curr; // head = k
        }
        return head;
    }
}