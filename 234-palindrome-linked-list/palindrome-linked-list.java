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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null || head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        ListNode prev = null;

        while(slow != null)
        {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow = head;

        while(prev != null)
        {
            if(slow.val != prev.val) return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
}