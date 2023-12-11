/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        ans = null;
        solve(cloned, target.val);
        return ans;
    }
    public void solve(TreeNode node, int target)
    {
        if(node == null) return;

        if(node.val == target){
            ans = node;
            return;
        }

        solve(node.left, target);
        solve(node.right, target);
    }
}