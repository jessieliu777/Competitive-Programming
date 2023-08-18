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
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);
        ListNode curSmall = dummySmall, curLarge = dummyLarge;
        while (head != null) {
            // since associativity of = operator is from right to left, a = b = c LEQV a = (b = c)
            // append nodes smaller than x in the small ll, move cur pointer for small to its nxt
            if (head.val < x) curSmall = curSmall.next = head;
            // same with bigger
            else curLarge = curLarge.next = head;
            head = head.next;
        }
        // since curSmall ends at the last element smaller than x, simply append the large ll
        curSmall.next = dummyLarge.next;
        // the very last larger node shouldn't point to anything
        curLarge.next = null;
        return dummySmall.next;
    }
}