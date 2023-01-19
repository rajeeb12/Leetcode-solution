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
    int index=0;
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list= new ArrayList<>();
        traverse(root,list);
        Collections.sort(list);
        inorder(root,list);
    }
    public void inorder(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return;
        
        inorder(root.left,list);
        root.val= list.get(index++);
        inorder(root.right,list);
    }
    public static void traverse(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
            return;
        
        traverse(root.left,list);
        list.add(root.val);
        traverse(root.right,list);
    }
}