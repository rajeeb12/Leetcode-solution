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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1;
        int carry = 0;
        ListNode prev = null;
        
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry; 
            l1.val = sum % 10;
            carry = sum / 10;
            prev= l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            int sum = l1.val + carry;
            l1.val = sum % 10;
            carry = sum / 10;
            prev= l1;
            l1 = l1.next;
        }
        while(l2 != null)
        {
            int sum = l2.val + carry;
            l2.val = sum % 10;
            prev.next = l2;
            prev = l2;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry == 1)
        {
            ListNode node = new ListNode(carry);
            prev.next = node;
            return head;
        }
        return head;
    }
}