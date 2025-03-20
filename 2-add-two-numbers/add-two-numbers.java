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
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;
        
        int carry = 0;

        while(list1 != null && list2 != null){
            int sum = list1.val + list2.val + carry;
            ListNode node = new ListNode(0);
            node.val = sum % 10;
            carry = sum / 10;
            cur.next = node;
            cur = node;
            list1 = list1.next;
            list2 = list2.next;
        }
        while(list1 != null){
            int sum = list1.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(rem);
            cur.next = node;
            cur = node;
            list1 = list1.next;
        }
        while(list2 != null){
            int sum = list2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(rem);
            cur.next = node;
            cur = node;
            list2 = list2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(1);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }
}