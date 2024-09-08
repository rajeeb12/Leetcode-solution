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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = getSize(head);
        ListNode ans[] = new ListNode[k];

        if(head == null) return ans;

        int parts = size / k;
        int extra = size % k;
        ListNode cur = head;
        for(int i = 0; cur != null && i < k ; i++ , extra--){
            ans[i] = cur;
        
            ListNode prev = null;
            int count = 0;
            for(int j = 0; j < parts + (extra > 0 ? 1 : 0); j++){
                prev = cur;
                cur = cur.next;
            }

            if(prev != null)
            {
                prev.next = null;
            }
        }
        return ans;

    }
    public int getSize(ListNode head){
        ListNode cur = head;
        int count = 0;

        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}