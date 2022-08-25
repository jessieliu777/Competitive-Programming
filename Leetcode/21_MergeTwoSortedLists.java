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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // traverse through every element
        ListNode head = new ListNode();
        ListNode tail = head;
        while (list1 != null || list2 != null){
            if (list1 == null){
                tail.next = list2;
                list2 = list2.next;
            }
            else if (list2 == null){
                tail.next = list1;
                list1 = list1.next;
                
            } else {
                if (list1.val < list2.val){
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
            }
            tail = tail.next;
        }
        return head.next;
    }
}