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
        ListNode slow = head;
        ListNode fast = head;

        if(head.next == null || head == null) return;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode n2 = reverse(slow.next);
        ListNode n1 = head;

        while(n2 != null)
        {
            ListNode next1 = n1.next;
            ListNode next2 = n2.next;
            n1.next = n2;
            n2.next = next1;
            n1 = next1;
            n2 = next2; 
        }
        n1.next = null;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}