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
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        
        int[] max= new int[1];
        max[0]=Integer.MIN_VALUE;
        getValue(root,max);
        return max[0];
    }
    public int getValue(TreeNode root,int[] max)
    {
        if(root==null)
            return 0;
        
        int leftSum =Math.max(0, getValue(root.left,max));
        int rightSum =Math.max(0, getValue(root.right,max));
        
        max[0] = Math.max(max[0] , root.val + leftSum + rightSum);
        
        return root.val + Math.max(leftSum ,rightSum);
    }
}