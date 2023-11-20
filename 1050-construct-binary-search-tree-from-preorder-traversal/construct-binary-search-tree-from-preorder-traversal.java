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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        
        for(int i = 1 ; i < preorder.length; i++){
            TreeNode node = new TreeNode(preorder[i]);
            insertIntoBST(root, node);
        }
        return root;
        
    }
    public TreeNode insertIntoBST(TreeNode root, TreeNode node){
        
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur != null){
            if(cur.val < node.val){
                prev = cur;
                cur = cur.right;
            }
            else{
                prev = cur;
                cur = cur.left; 
            }
        }
        if(prev.val > node.val){
            prev.left = node;
        }
        else{
            prev.right = node;
        }
        return root;
    }
}