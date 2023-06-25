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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i: nums) set.add(i);
        int res = 0;
        while (head != null) {
            // to get the number of connected components <=> get the number of tails in the connected components <=> get the number of numbers where the next number is not in cur component
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) res++;
            head = head.next;
        }
        return res;
    }
}