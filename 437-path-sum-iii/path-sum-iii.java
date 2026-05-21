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
    int counter=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        
        dfs(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return counter;
    }
    public void dfs(TreeNode root,int t,long s)
    {
        if(root==null)
            return;
        s += root.val;
        if(t==s)
            counter++;
        
        dfs(root.left,t,s);
        dfs(root.right,t,s);
    }
}