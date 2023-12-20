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
        return solve(root, Integer.MIN_VALUE);
    }
    public int solve(TreeNode root, int max)
    {
        if(root == null) return 0;

        int res = root.val >= max ? 1 : 0;

        res += solve(root.left, Math.max(root.val, max));
        res += solve(root.right, Math.max(root.val, max));

        return res;
    }

}