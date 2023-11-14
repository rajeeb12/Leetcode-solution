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
    public boolean isSymmetric(TreeNode root) {
        return solve(root.left, root.right);
    }
    public boolean solve(TreeNode node1, TreeNode node2){
        if(node1 == null || node2 ==null){
            return (node1 == node2);
        } 

        return (node1.val == node2.val && solve(node1.left, node2.right) && solve(node1.right, node2.left));
    }
}