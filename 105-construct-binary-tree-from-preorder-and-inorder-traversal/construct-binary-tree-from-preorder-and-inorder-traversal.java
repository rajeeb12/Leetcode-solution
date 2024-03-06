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
        HashMap<Integer,Integer> map= new HashMap<>();
        int np = preorder.length;
        int ni = inorder.length;
        for(int i =0; i < ni; i++)
        {
            map.put(inorder[i] , i);
        }
        return solve(preorder,0,np-1, inorder, 0 , ni -1, map);
    }
    public TreeNode solve(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,HashMap<Integer,Integer> map)
    {
        if(ps > pe || is > ie) return null;

        TreeNode root = new TreeNode(preorder[ps]);

        int index = map.get(preorder[ps]);
        int remLeft = index - is;
        root.left = solve(preorder, ps + 1, ps + remLeft + 1, inorder,is , index - 1, map); 
        root.right = solve(preorder, ps + remLeft +1, pe, inorder, index + 1 , ie, map);
        return root; 
    }
}