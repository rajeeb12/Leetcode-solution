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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        solve(root);
        return root;
    }
    public void solve(TreeNode root)
    {
        if(root == null) return;

        solve(root.right);
        sum += root.val;
        root.val = sum;
        solve(root.left);
    }
}