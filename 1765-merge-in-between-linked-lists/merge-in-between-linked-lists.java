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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode cur = list1;

        for(int i = 0 ; i <= b; i++)
        {
            if(i == a - 1) p1 = cur;
            if(i == b) p2 = cur;
            cur = cur.next;
        }
        ListNode head2 = list2;
        ListNode tail2 = list2;
        while(tail2.next != null)
        {
            tail2 = tail2.next;
        }
        p1.next = head2;
        tail2.next = p2.next;
        
        return list1;
    }
}