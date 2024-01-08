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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode(0);

        dummy.next = head;
        ListNode cur = dummy;

        for(int i = 1; i <= n ; i++)
        {
            cur = cur.next;
        }
        ListNode prev1 = dummy;
        while(cur.next != null)
        {
            prev1 = prev1.next;
            cur = cur.next;
        }
        prev1.next = prev1.next.next; 
        return dummy.next;
    }
}