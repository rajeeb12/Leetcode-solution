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
        if(head.next == null && n == 1) return null;
        ListNode head1 = new ListNode(0);

        head1.next = head;
        ListNode prev =null;
        ListNode cur = head1;

        while(n != 1)
        {
            cur = cur.next;
            n--;
        }
        ListNode prev1 = head1;
        while(cur.next != null)
        {
            prev = prev1;
            prev1 = prev1.next;
            cur = cur.next;
        }

        prev.next = prev1.next;
        prev1.next = null;
        return head1.next;
    }
}