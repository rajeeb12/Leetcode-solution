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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int ni = inorder.length;
        int np = postorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < ni; i++)
        {
            map.put(inorder[i], i);
        }
        return solve(inorder,0,ni - 1, postorder, 0, np - 1, map);
    }
    public TreeNode solve(int[] inorder,int is,int ie,int[] postorder,int ps,int pe,HashMap<Integer,Integer> map)
    {
        if(is > ie || ps > pe) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int index = map.get(postorder[pe]);
        int remLeft = index - is;
        root.left = solve(inorder,is, index - 1, postorder, ps , ps + remLeft - 1, map);
        root.right = solve(inorder, index + 1, ie, postorder, ps + remLeft, pe - 1, map);
        return root;
    }
}