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
        // add both linked lists to stack
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        
        while(l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        };
        while(l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int sum = 0;
        ListNode list = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            // sum up the cur digits
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            // store the ones digit in cur node value
            list.val = sum % 10;
            // put the carry in its parent
            ListNode head = new ListNode(sum / 10);
            // make the carry point to the ones digit
            head.next = list;
            // set the carry to be the new head
            list = head;
            // the carry becomes the nxt ones digit in the nxt iteration
            sum /= 10;
        }
        
        return list.val == 0 ? list.next : list;
    }
}