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
    // from problem #21
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
    
    public ListNode mergeKLists(ListNode[] lists) {
        // divide into n/2 groups of 2, for each group merge
        // continue the same process with the merged groups
        // until there's only one list left
        int total = lists.length;
        int middle = total/2;
        if (total == 0){
            return null;
        }
        else if (total == 1){
            return lists[0];
        } else if (total == 2){
            return mergeTwoLists(lists[0], lists[1]);
        } else {
            ListNode[] list1 = Arrays.copyOfRange(lists, 0, middle);
            ListNode[] list2 = Arrays.copyOfRange(lists, middle, total);
            ListNode result1 = mergeKLists(list1);
            ListNode result2 = mergeKLists(list2);
            return mergeTwoLists(result1, result2);
        }
    }
}