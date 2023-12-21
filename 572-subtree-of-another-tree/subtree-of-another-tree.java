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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        if(solve(root, subRoot))
        {
            return true;
        }

        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);

        if(left == true || right == true) return true;
        return false;
    }

    public boolean solve(TreeNode r1,TreeNode r2)
    {
        if(r1 == null || r2 == null) return (r1 == r2);

        if(r1.val != r2.val){
            return false;
        }

        boolean left = solve(r1.left,r2.left);
        boolean right = solve(r1.right, r2.right);

        if(!left || !right) return false;
        return true;
    }
}