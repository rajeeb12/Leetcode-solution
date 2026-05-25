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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        solve(root, 0 , 0);
        return max;
    }
    public void solve(TreeNode root, int left, int right){
        if(root == null) return;

        max = Math.max(max, Math.max(left, right));
        solve(root.left, right + 1, 0);
        solve(root.right, 0, left + 1);
    }
}