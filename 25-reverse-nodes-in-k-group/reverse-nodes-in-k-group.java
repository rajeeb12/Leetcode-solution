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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        
        while(temp != null)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null)
            {
                if(prevNode != null) prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if(temp == head)
            {
                head = kthNode;
            }else{
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    public void reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode cur = head;
        
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
    public ListNode findKthNode(ListNode head, int k)
    {
        while(head != null && k > 1)
        {
            head = head.next;
            k--;
        }
        return head;
    }
}