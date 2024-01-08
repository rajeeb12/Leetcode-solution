/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean collide = false;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                collide = true;
                break;
            }
        }
        if(!collide) return null;

        ListNode entry = head;

        while(entry != slow)
        {
            entry = entry.next;
            slow = slow.next;
        }
        return entry;
    }
}