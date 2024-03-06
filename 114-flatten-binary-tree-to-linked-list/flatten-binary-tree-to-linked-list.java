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
    TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        solve(root);
    }
    public void solve(TreeNode root)
    {
        if(root== null ) return;

        solve(root.right);
        solve(root.left);

        root.right = prev;
        root.left = null;
        prev= root;
    }
}