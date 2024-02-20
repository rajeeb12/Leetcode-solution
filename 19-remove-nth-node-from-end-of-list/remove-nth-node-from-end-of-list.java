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

        ListNode fast = head;
        int count = 0;
        while(fast != null)
        {
            fast = fast.next;
            count++;
        }
        int val = count - n;
        if(val == 0 ) return head.next;
        ListNode prev = null;
        fast = head;
        for(int i = 1; i <= val; i++)
        {
            prev = fast;
            fast = fast.next;
        }
        prev.next = fast.next;
        return head;
    }
}