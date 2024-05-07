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
    public ListNode removeNodes(ListNode head) {
        ListNode cur = reverse(head);
        ListNode dummy = new ListNode(0);
        dummy.next = cur;
        ListNode track = cur;

        int max = cur.val;
        cur = cur.next;
        while(cur != null)
        {
            if(cur.val >= max){
                track.next = cur;
                track = cur;
                max = cur.val;
            }
            cur = cur.next;
        }
        track.next = null;
        return reverse(dummy.next);
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}