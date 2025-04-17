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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> ans = new ArrayList<>();
        if(root == null) return ans;
        solve(root, "", ans);
        return ans;
    }
    public void solve(TreeNode root, String temp, List<String> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            ans.add(temp + root.val);
            return;
        }

        solve(root.left, temp +root.val +"->", ans);
        solve(root.right, temp + root.val+"->",ans);
    }
}