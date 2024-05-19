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
    int count;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        count = 0;
        solve(root, -1);

        return count;
    }
    public int solve(TreeNode root,int val)
    {
        if(root == null) return 0;

        int left = solve(root.left, root.val);
        int right = solve(root.right, root.val);
        count = Math.max(count, left + right);

        if(root.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}