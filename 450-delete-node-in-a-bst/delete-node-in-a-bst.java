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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key)
        {
            return helper(root);
        }
        TreeNode cur = root;
        while(cur != null)
        {
            if(cur.val > key)
            {
                if(cur.left != null && cur.left.val == key)
                {
                    cur.left = helper(cur.left);
                    break;
                }else{
                    cur = cur.left;
                }
            }else{
                if(cur.right != null && cur.right.val == key)
                {
                    cur.right = helper(cur.right);
                    break;
                }else{
                    cur= cur.right;
                }
            }
        }
        return root;
    }
    public TreeNode helper(TreeNode root)
    {
        if(root.left == null)
        {
            return root.right;
        }else if(root.right ==null)
        {
            return root.left;
        }

        TreeNode rightChild = root.right;
        TreeNode lastLeftsRightChild = find(root.left);
        lastLeftsRightChild.right = rightChild; 
        return root.left;
    }
    public TreeNode find(TreeNode node)
    {
        while(node.right != null)
        {
            node = node.right;
        }
        return node;
    }
}