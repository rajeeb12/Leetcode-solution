/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right  == null) return 1;
        int ans[] = new int[1];
        int temp = solve(root, ans);
        return (temp < 0 ? ++ans[0] : ans[0]);
    }
    public int solve(TreeNode root,int[] ans){
        if(root == null) return 1;

        int lc = solve(root.left,ans);
        int rc = solve(root.right,ans);
        
        if(lc == -1 || rc == -1)
        {
            ans[0]++;
            return 0;
        }
        if(lc == 0 || rc == 0){
            return 1;
        }
        return -1;
    }
}