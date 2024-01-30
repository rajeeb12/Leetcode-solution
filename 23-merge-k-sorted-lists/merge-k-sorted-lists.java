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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length; 
        if(lists == null) return null;
        for(int i = 1; i < n; i++)
        {
            merge(lists[0], lists[i], 0, lists);
        }
        return (n > 0 ? lists[0] : null);
    }
    public void merge(ListNode l1,ListNode l2, int index,ListNode[] ls)
    {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next; 
            }
            cur = cur.next;
        }
        while(l1 != null)
        {
            cur.next = l1;
            l1= l1.next;
            cur = cur.next;
        }
        while(l2 != null)
        {
            cur.next = l2;
            l2= l2.next;
            cur = cur.next;
        }
        ls[index] = dummy.next;
    }
}