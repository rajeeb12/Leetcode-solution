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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack= new Stack<>();
        
        stack.push(root);
        TreeNode cur;
        while(!stack.isEmpty())
        {
            cur= stack.pop();
            if(root.right != null)
            {
                stack.push(root.right);
            }
            if(root.left != null)
            {
                stack.push(root.left);
            }
            
            if(!stack.isEmpty())
            {
                cur.right = stack.peek();
            }
            cur.left=null;
        }
    }
}