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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        int index = 2;
        ListNode cur = head.next;
        ListNode p1 = head;
        ListNode p2 = head;

        while(cur != null)
        {
            if(index % 2 != 0)
            {
                ListNode next1 = p1.next;
                ListNode next2 = cur.next;
                p1.next = cur; 
                cur.next = next1;
                p2.next = next2;
                p1 = p1.next;
                cur = p2;
            }
            p2 = cur;
            cur = cur.next;
            index++;
        }  

        return head;
    }
}