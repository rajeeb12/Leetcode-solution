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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null || head.next == null || head == null){
            return new int[]{-1,-1};
        }
        List<Integer> ls = new ArrayList<>();
        ListNode prev = head;
        ListNode cur = head.next;
        
        int index = 1;
        while(cur.next != null){
            if((cur.val > prev.val && cur.val > cur.next.val) || (cur.val < prev.val && cur.val < cur.next.val)){
                ls.add(index);
            }
            index++;
            prev = cur;
            cur = cur.next;
        } 
        if(ls.size() < 2){
            return new int[]{-1, -1};
        }

        int maxDistance = ls.get(ls.size() - 1) - ls.get(0);
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < ls.size() - 1; i++){
            minDistance = Math.min(minDistance, ls.get(i + 1) - ls.get(i));
        }
        return new int[]{minDistance, maxDistance};
    }
}