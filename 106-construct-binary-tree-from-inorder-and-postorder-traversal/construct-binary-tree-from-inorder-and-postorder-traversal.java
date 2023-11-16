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
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length-1;
        int m = postorder.length-1;
        map = new HashMap<>();
        for(int i = 0; i <= n; i++){
            map.put(inorder[i],i);
        }
        return solve(0,n,inorder,0,m,postorder);
    }
    public TreeNode solve(int inStart,int inEnd,int[] inorder,int posStart,int posEnd,int[] postorder){
        if(inStart > inEnd || posStart > posEnd){
            return null;
        }

        TreeNode node = new TreeNode(postorder[posEnd]);

        int inRoot = map.get(node.val);
        int numLeft = inRoot - inStart;

        node.left = solve(inStart , inRoot - 1, inorder, posStart, posStart + numLeft - 1, postorder);
        node.right = solve(inRoot + 1 , inEnd, inorder, posStart + numLeft , posEnd-1, postorder);

        return node;
    }
}