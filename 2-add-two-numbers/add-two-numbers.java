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
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + carry;
            ListNode d = new ListNode(sum % 10);
            cur.next = d;
            cur = cur.next;
            carry = (sum / 10); 
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null)
        {
            int sum = carry + l1.val;
            ListNode d = new ListNode(sum % 10);
            cur.next = d;
            cur = cur.next;
            carry = sum / 10;
            l1 = l1.next;
        }
        while(l2 != null)
        {
            int sum = carry + l2.val;
            ListNode d = new ListNode(sum % 10);
            cur.next = d;
            cur = cur.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry == 1)
        {
            ListNode d = new ListNode(carry % 10);
            cur.next= d;
        }
        return dummy.next;
    }
}