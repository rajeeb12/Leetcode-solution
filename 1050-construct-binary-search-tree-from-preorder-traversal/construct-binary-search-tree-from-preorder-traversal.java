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
    // only using recurion
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;
        return construct(Integer.MAX_VALUE,new int[]{0},preorder);
    }
    public TreeNode construct(int upperBound,int index[],int[] preorder)
    {
        if(index[0] == preorder.length || preorder[index[0]] > upperBound){
            return null;
        }

        TreeNode node= new TreeNode(preorder[index[0]++]);
        node.left = construct(node.val,index,preorder);
        node.right = construct(upperBound,index,preorder);
        return node;
    }
}