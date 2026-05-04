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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder left = new StringBuilder("");
        StringBuilder right = new StringBuilder("");

        solve(root1, left);
        solve(root2, right);
        System.out.print(left+" "+right);

        if(left.length() != right.length()) return false;

        if(left.toString().equals(right.toString())) return true;
        return false;
    }
    public void solve(TreeNode node,StringBuilder str){
        if(node == null) return;
        if(node.left == null && node.right == null){
            str.append(node.val+"|");
            return;
        }
        solve(node.left, str);
        solve(node.right, str);
    }
}