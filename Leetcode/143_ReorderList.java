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
    public void reorderList(ListNode head) {
        // for example 0 -> 1 -> 2 ...-> n-1 -> n
        ListNode[] left =  new ListNode[1];// it will create in heap
        left[0] = head; // left = 0, right = 0
        reorder(left, head);
    }
    
    // left pointer will be created in heap and right pointer will be created in stack
     public void reorder(ListNode left[],ListNode right){
        if(right==null) return;
         // reorder the heap with the next node onwards
        reorder(left,right.next); // reorder(0, 1) -> reorder (0, 2),.., reorder(0, n), reorder(0, null) => passing in null returns right away so the very first executed after null is reorder(0, n)
        // continuing onwards with base case left = 0, right = n
         // if left.next = 0.next = 1 
        if(left[0].next!=null){
            ListNode leftNext =  left[0].next; // leftNext = 0.next = 1
            left[0].next =  right; // left.next = right = n
            right.next =  leftNext; // right.next = leftNext = 1
            left[0] =  leftNext; // left = leftNext = 1
            // now we have 0 -> n -> 1 -> 2 ... -> n-1, where left = 1. Now we just do the same thing from 1 -> ... -> n-1
        }
        
        // if heap = stack then stop continuing the heap
        if(left[0].next == right){
            left[0].next =  null;
            return;
        }                        
    }
}