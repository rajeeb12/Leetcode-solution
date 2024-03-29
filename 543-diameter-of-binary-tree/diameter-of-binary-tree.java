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
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        helper(root);
        return max;
    }
    public int helper(TreeNode root)
    {
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }
}