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
        if(head == null) return 0;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur2 = reverse(slow);
        ListNode cur = head;
        
        int maxSum = 0;
        while(cur2 != null)
        {
            int sum = cur.val + cur2.val;
            maxSum = Math.max(sum , maxSum);
            cur = cur.next;
            cur2 = cur2.next;
        }
        return maxSum;
        
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}