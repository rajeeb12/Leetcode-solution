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
class BSTIterator{
    TreeNode root;
    boolean reverse = true;
    Stack<TreeNode> stack= new Stack<>();
    BSTIterator(TreeNode root,boolean isReverse)
    {
        reverse= isReverse;
        pushAll(root);
    }
    
    public int next()
    {
        TreeNode node= stack.pop();
        int ans = node.val;
        if(!reverse)
        {
            if(node.right != null)
            {
                pushAll(node.right);
            }
        }
        else
        {
            if(node.left != null)
            {
                 pushAll(node.left);
            }
        }
        return ans;
    }
    public void pushAll(TreeNode root)
    {
        while(root!= null)
        {
            if(!reverse)
            {
                stack.add(root);
                root= root.left;
            }
            else
            {
                stack.add(root);
                root= root.right;
            }
        }
    }
    
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        BSTIterator l = new BSTIterator(root,false);
        BSTIterator r = new BSTIterator(root,true);
        
        int i= l.next();
        int j= r.next();
        
        while(i<j)
        {
            if(i+j==k)
                return true;
            else if(i+j > k)
            {
                j= r.next();
            }
            else
            {
                i= l.next();
            }
        }
        return false;
    }
}