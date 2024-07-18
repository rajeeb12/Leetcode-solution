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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        TreeNode node = lca(root, startValue, destValue);

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();

        dfs(node, left, startValue);
        dfs(node, right, destValue);
        
        // System.out.print(left);

        String ans ="";
        for(int i = 0; i < left.length(); i++)
        {
            ans += 'U';
        }
        return (ans + right.toString());
    }
    public boolean dfs(TreeNode root, StringBuilder s,int value)
    {
        if(root == null) return false;
        
        if(root.val == value) return true;
        
        s.append('L');
       
        if(dfs(root.left, s , value)) return true;

        s.deleteCharAt(s.length() - 1);
        
        s.append('R');
        
        if(dfs(root.right, s, value)) return true;

        s.deleteCharAt(s.length() - 1);
        return false;
    }
    public TreeNode lca(TreeNode root,int s,int d){
        if(root == null) return root;

        if(root.val == s || root.val == d) return root;

        TreeNode left = lca(root.left, s, d);
        TreeNode right = lca(root.right, s, d);

        if(left == null)
        {
            return right;
        }else if(right == null){
            return left;
        }
        return root;
    }
}