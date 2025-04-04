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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) return root;
        if(root.left == null && root.right == null) return root;
        int depth = dfs(root);
        // System.out.print(depth);
        return LCA(root,depth);
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        return 1 + Math.max(left, right);
    }
    public TreeNode LCA(TreeNode root,int depth){
        if(root == null) return root;
        if(depth == 1) return root;

        TreeNode left = LCA(root.left, depth - 1);
        TreeNode right = LCA(root.right, depth - 1);

        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        return root;
    }
}