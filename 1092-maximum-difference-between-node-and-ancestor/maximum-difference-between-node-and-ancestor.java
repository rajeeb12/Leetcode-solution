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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) return 0;
        return solve(root, root.val, root.val);
    }
    public int solve(TreeNode root, int max,int min)
    {
        if(root == null)
        {
            return max - min;
        }

        int left = solve(root.left, Math.max(max, root.val), Math.min(min, root.val));
        int right = solve(root.right, Math.max(max, root.val), Math.min(min, root.val));

        return Math.max(left, right);
    }
}