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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;

        ListNode dummyOdd = new ListNode(0);
        ListNode dummyEven = new ListNode(0);
        ListNode odd = dummyOdd;
        ListNode even = dummyEven;
        int index = 0;
        while(head != null){
            if(index % 2 == 0){
                odd.next = head;
                odd = odd.next;
            }else{
                even.next = head;
                even = even.next;
            }
            head = head.next;
            index++;
        }
        even.next = null;
        odd.next = dummyEven.next;
        return dummyOdd.next;
    }
}