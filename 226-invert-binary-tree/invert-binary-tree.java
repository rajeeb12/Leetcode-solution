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
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }
    public TreeNode solve(TreeNode node){
        if(node == null) return node;

        TreeNode left = solve(node.left);
        TreeNode right = solve(node.right);

        TreeNode temp = left;
        node.left = right;
        node.right = left;

        return node; 
    }
}