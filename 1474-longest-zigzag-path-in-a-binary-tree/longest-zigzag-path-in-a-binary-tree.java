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
    int maxPath = 0 ;
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        solve(root, 0 , false);
        solve(root, 0, true);
        return maxPath;
    }
    public void solve(TreeNode root,int steps,boolean goLeft){
        if(root == null) return;
         
        maxPath = Math.max(maxPath, steps);
        if(goLeft){
            solve(root.left, steps + 1, false);
            solve(root.right, 1 , true);
        }else{
            solve(root.right, steps + 1, true);
            solve(root.left, 1, false);
        }
    }
}