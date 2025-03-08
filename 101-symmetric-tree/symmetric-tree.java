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
    public boolean solve(TreeNode lNode,TreeNode rNode){
        if(lNode == null || rNode == null) return (lNode == rNode);
        if(lNode.val != rNode.val) return false;
        
        if(solve(lNode.left, rNode.right) && solve(lNode.right, rNode.left)){
            return true;
        }
        return false;
    }
}