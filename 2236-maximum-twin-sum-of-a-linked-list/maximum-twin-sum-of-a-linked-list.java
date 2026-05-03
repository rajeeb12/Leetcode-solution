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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = getRev(slow.next);
        slow.next = node;
        ListNode start = head;
        int max = 0; 
        while(node != null){
            max = Math.max(max, node.val + start.val);
            node = node.next;
            start = start.next;
        }
        return max;
    }
    public ListNode getRev(ListNode head){
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