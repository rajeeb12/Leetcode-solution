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
        int count = 0;
        ListNode cur = head;
        while(cur != null)
        {
            cur = cur.next;
            count++;
        }
        int len = count - n;
        if(len == 0) return head.next;
        
        ListNode prev = null; 
        cur = head;
        for(int i = 1; i <= count - n ; i++)
        {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }
}