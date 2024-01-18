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
    public int goodNodes(TreeNode root) {
        count = 0;
        solve(root, root.val);
        return count;
    }
    public void solve(TreeNode root,int max)
    {
        if(root == null) return;

        if(root.val >= max)
        {
            count++; 
        }
        solve(root.left, Math.max(root.val, max));
        solve(root.right, Math.max(root.val, max));
    }
}