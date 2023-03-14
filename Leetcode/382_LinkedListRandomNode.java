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
    // use resevoir sampling:
    // Choose 1, 2, 3, ..., k first and put them into the reservoir.
    // Start with k+1, pick it with a probability of k/(k+1), and randomly replace a number in the reservoir.
    // for the following k+i element, pick it with a probability of k/(k+i), and randomly replace a number in the reservoir.
    // Repeat until k+i reaches n
    
    // This problem is a special case where k = 1
    // for every node, add the node to the 'resevoir', it has 1/cur_resevoir_size chance of getting picked
    // for example, start with first node. Add it to resevoir. The resevoir has only 1 node, so p(first node picked) = 1/1. Next is 2nd node, add it to resevoir. The resevoir now has 2 nodes. so p(2nd node picked) = 1/2
    
    ListNode head = null;
    Random r = new Random();
    int k = 1;

    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int result = this.head.val;
        ListNode node = this.head.next;
        int resevoirSize = 1;
        while(node != null){
            double x = r.nextDouble();
            double y = k / (k + resevoirSize *1.0);           
            if(x <= y) result = node.val;
            resevoirSize++;
            node = node.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */