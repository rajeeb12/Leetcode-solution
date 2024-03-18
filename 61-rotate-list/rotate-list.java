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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode cur = head;
        int n = 0;
        while(cur.next != null)
        {
            cur = cur.next;
            n++;
        }
        n++;
        k %= n;

        int go = n - k - 1;
        ListNode temp = head;
        for(int i = 0 ; i < go; i++)
        {
            temp = temp.next;
        }
        cur.next = head;
        head = temp.next;
        temp.next = null;
        return head; 
    }
}