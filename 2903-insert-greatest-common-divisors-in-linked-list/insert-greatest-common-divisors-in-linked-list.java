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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        ListNode cur = head;

        while(cur.next != null)
        {
            ListNode next = cur.next;
            int gcd = getGcd(cur.val, next.val);
            ListNode node = new ListNode(gcd);
            cur.next = node;
            node.next = next;
            cur = next;
        }

        return head;
    }
    public int getGcd(int a,int b){
        if(a == 0) return b;
        return getGcd(b % a, a);
    }
}