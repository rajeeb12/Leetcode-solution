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
        ArrayList<Integer> temp = new ArrayList<>();
        if(lists == null || lists.length == 0) return null;
        int n = lists.length;
        for(int i = 0 ; i < n ; i++)
        {
            ListNode cur = lists[i];
            while(cur != null)
            {
                temp.add(cur.val);
                cur = cur.next;
            }
        }
        Collections.sort(temp);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i : temp)
        {
            ListNode newNode = new ListNode(i);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
}