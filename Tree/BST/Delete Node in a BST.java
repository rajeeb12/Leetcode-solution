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
    public TreeNode deleteNode(TreeNode node, int key) {
        
        if(node==null)
            return null;
        
        if(node.val==key)
            return helper(node);
        
        TreeNode root= node;
        while(root != null)
        {
            if(root.val > key)
            {
                if(root.left != null && root.left.val==key)
                {
                    root.left= helper(root.left);
                    break;
                }
                else
                {
                    root=root.left;
                }
            }
            else
            {
                if(root.right != null && root.right.val==key)
                {
                    root.right= helper(root.right);
                    break;
                }
                else
                {
                    root=root.right;
                }
            }
        }
        return node;
    }
    public static TreeNode helper(TreeNode root)
    {
        if(root.left==null)
        {
            return root.right;
        }
        else if(root.right==null)
        {
            return root.left;
        }
        else
        {   
            TreeNode rightChild= root.right;
            TreeNode lastRight= find(root.left);
            lastRight.right= rightChild;
            return root.left;
        }
    }
    public static TreeNode find(TreeNode root)
    {
        if(root.right==null)
            return root;
        
        return find(root.right);
    }
}