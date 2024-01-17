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

        HashMap<Integer,ListNode> map = new HashMap<>();
        int index = 0 ;
        ListNode cur = head;
        
        while(cur != null)
        {
            map.put(index, cur);
            cur = cur.next;
            index++;
        }
        int maxSum = 0;
        for(int i = 0 ; i < index / 2; i++)
        {
            int sum = map.get(i).val + map.get(index - i - 1).val;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}