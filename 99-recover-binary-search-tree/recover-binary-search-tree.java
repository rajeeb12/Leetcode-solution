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
    TreeNode prev = null;
    TreeNode first =null , middle = null , last = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        inorder(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    public void inorder(TreeNode root)
    {
        if(root == null) return;

        inorder(root.left);

        if(prev != null && (root.val < prev.val)){
            if(first == null){ // first violation
                first = prev;
                middle = root; 
            }else{ // second violation
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}