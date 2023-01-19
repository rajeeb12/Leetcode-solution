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
    public List<Integer> rightSideView(TreeNode root) {
        //DFS
        List<Integer> ans= new ArrayList<>();
        if(root==null)
            return ans;
        
        solution(root,0,ans);
        return ans;
    }
    public static void solution(TreeNode root,int level,List<Integer> ds)
    {
        if(root==null)
            return;
        
        if(level == ds.size())
            ds.add(root.val);
        
        solution(root.right,level+1,ds);
        solution(root.left,level+1,ds);
    }
}