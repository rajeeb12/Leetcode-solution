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
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        
        int left= getHeight(root.left);
        int right= getHeight(root.right);
        
        if(Math.abs(left-right) > 1)
            return false;
        
        boolean lh= isBalanced(root.left); // for each  left node
        boolean rh= isBalanced(root.right); // for each right node 
        
        if(!lh || !rh)
            return false;
        
        return true;
    }
    public static int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        
        int left= getHeight(root.left);
        int right=  getHeight(root.right);
        
        return 1+ Math.max(left,right);
    }
}