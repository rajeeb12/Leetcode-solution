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
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = new int[1];
        solve(root, ans);
        return ans[0];
    }
    public int solve(TreeNode root,int ans[])
    {
        if(root == null) return 0;

        int left = solve(root.left, ans);
        int right = solve(root.right, ans);

        ans[0] = Math.max(ans[0], left + right);

        return 1 + Math.max(left, right);
    }
}