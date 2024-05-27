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
    public int goodNodes(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        int count[] = new int[1];
    
        solve(root,count,Integer.MIN_VALUE);
        return count[0];
    }
    public void solve(TreeNode root,int[] count,int prev_max)
    {
        if(root == null) return;

        if(root.val >= prev_max) count[0]++;

        solve(root.left,count, Math.max(root.val, prev_max));
        solve(root.right, count, Math.max(root.val, prev_max));
    }
}