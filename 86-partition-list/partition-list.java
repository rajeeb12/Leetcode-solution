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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);

        ListNode smallPointer = small;
        ListNode bigPointer = big;

        ListNode cur = head;

        while(cur != null){
            if(cur.val < x){
                smallPointer.next = cur;
                smallPointer = smallPointer.next;
            }else{
                bigPointer.next = cur;
                bigPointer = bigPointer.next;
            }
            cur = cur.next;
        }
        smallPointer.next = big.next;
        bigPointer.next = null;
        return small.next;
    }
}