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

        for(int i = 1; i < n; i++)
        {
            merge(lists[0], lists[i], 0, lists);
        }
        return (n > 0 ? lists[0] : null);
    }
    public void merge(ListNode list1,ListNode list2,int index,ListNode[] lists)
    {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                cur.next = list1;
                list1 = list1.next; 
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        while(list1 != null)
        {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while(list2 != null)
        {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        lists[0] = dummy.next;
    }
}