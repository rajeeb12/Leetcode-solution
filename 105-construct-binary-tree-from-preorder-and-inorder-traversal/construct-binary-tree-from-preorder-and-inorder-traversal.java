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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i = 0 ; i < m ; i++){
            map.put(inorder[i], i);
        }
        return construct(0,n-1,preorder, 0,m-1,inorder, map);
    }
    public TreeNode construct(int preStart,int preEnd,int[] preOrder,int inStart,int inEnd,int[] inOrder,HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode node= new TreeNode(preOrder[preStart]);
        int pNodePos = map.get(node.val);
        int nElement =pNodePos - inStart;

        node.left = construct(preStart+1,preStart + nElement,preOrder,inStart,pNodePos - 1,inOrder, map); 
        node.right = construct(nElement + preStart + 1,preEnd,preOrder,pNodePos + 1, inEnd,inOrder, map); 

        return node;
    }
}