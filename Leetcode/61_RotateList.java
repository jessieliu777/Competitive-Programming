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
    public ListNode rotateRight(ListNode head, int k) {
        if( head==null || head.next==null ) return head;
        
        int size=1;
        ListNode cur = head;
        
        //find size of list
        while(cur.next!=null){
            size++;
            cur=cur.next;
        }

        k=k%size;
        // make the last node point to head (rotate 1)
        cur.next=head;
        
        // find the node that would be the last after rotating
        while((size-k)>0){
            head=head.next;
            cur=cur.next;
            k++;
        }
        // set it to null so it's the last node
        cur.next=null;
        
        return head;
    }
}