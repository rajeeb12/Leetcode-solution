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
    int ans=0;
    public int kthSmallest(TreeNode root, int k) {
        morris(root,k);
        return ans;
    }
    public void morris(TreeNode root,int k)
    {
        while(root != null)
        {
            if(root.left == null)
            {
                k--;
                if(k==0) 
                {
                    ans= root.val;
                    break;
                }
                root= root.right;
            }
            else
            {
                TreeNode prev= root.left;
                while(prev.right != null && prev.right!=root)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right = root;
                    root =root.left;
                }
                else
                {
                    prev.right =null;
                    k--;
                    if(k==0) 
                    {
                        ans= root.val;
                        break;
                    }
                    root= root.right;
                }
            }
        }
    }
}