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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];
        int r1 = 0, r2 = m - 1 , c1 = 0,c2 = n - 1;

        if(head == null) return ans;
        
        for(int i[]: ans) Arrays.fill(i, -1);
        ListNode cur = head;
        while(r1 <= r2 && c1 <= c2 && cur != null)
        {
            for(int i = c1; i <= c2 && cur != null; i++){
                ans[r1][i] = cur.val;
                cur = cur.next;
            }
            r1++;

            for(int j = r1; j <= r2 && cur != null; j++){
                ans[j][c2] = cur.val;
                cur = cur.next;
            }
            c2--;

            if(c1 <= c2){
                for(int j = c2; j >= c1 && cur != null; j--){
                    ans[r2][j] = cur.val;
                    cur = cur.next;
                }
                r2--;
            }

            if(r1 <= r2){
                for(int i = r2; i >= r1 && cur != null; i--){
                    ans[i][c1] = cur.val;
                    cur= cur.next;
                }
                c1++;
            }
        }
        return ans;
    }
}