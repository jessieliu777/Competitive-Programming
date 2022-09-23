/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean cycle = false;
        while (head != null && !cycle){
            set.add(head);
            if (set.contains(head.next)){
                cycle = true;
            }
            head = head.next;
        }
        return cycle;
    }
}