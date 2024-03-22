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
        if(head == null || head.next == null) return true;
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow.next);
        slow.next = rev;
        ListNode cur = head;
        while(rev != null)
        {
            if(cur.val != rev.val)
            {
                return false;
            }
            cur = cur.next;
            rev = rev.next;
        }
        return true;
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