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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
        {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        depth -= 2;
        
        dfs(root, val,depth,0);
        return root;
    }
    public static TreeNode dfs(TreeNode root, int val,int depth,int level){
        if(root == null) return root;
        
        if(depth == level){
            TreeNode tl = root.left;
            TreeNode tr = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = tl;
            root.right.right = tr;

            return root;
        }

        root.left =  dfs(root.left, val,depth,level + 1);
        root.right =  dfs(root.right, val,depth,level + 1);

        return root;
    }
}