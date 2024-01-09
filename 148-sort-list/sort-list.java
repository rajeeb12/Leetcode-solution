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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;

        ArrayList<Integer> temp = new ArrayList<>();
        ListNode dummy = head;

        while(dummy != null)
        {
            temp.add(dummy.val);
            dummy = dummy.next;
        }
        Collections.sort(temp);
        dummy = head;
        for(int i = 0 ; i < temp.size(); i++)
        {
            dummy.val = temp.get(i);
            dummy = dummy.next;
        }
        return head;
    }
}