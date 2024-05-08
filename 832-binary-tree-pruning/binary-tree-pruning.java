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
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return root;
        int val = solve(root);
        return (val == 0 ? null : root);
    }
    public int solve(TreeNode root)
    {
        if(root == null) return 0;

        int lc = solve(root.left);
        int rc = solve(root.right);

        if(lc == 0)
        {
            root.left = null;
        }
        if(rc == 0)
        {
            root.right = null;
        }
        if(root.val == 1) return 1;

        return (lc == 0 && rc == 0 ? 0 : 1);
    }
}