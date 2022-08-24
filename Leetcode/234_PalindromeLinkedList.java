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
    public boolean isPalindrome(List<Integer> ll){
        boolean result = true;
        int len = ll.size();
        for (int i = 0; i < len/2; i++){
            if (ll.get(i) != ll.get(len-i-1)) {
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> ll = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            ll.add(cur.val);
            cur = cur.next;
        }
        return (isPalindrome(ll));
    }
}