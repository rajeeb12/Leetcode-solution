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
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> ls = new ArrayList<>();

        solve(root,"", ls);
        Collections.sort(ls);
        return ls.get(0);
    }
    public static void solve(TreeNode root,String s,ArrayList<String> ls)
    {
        if(root== null){
            return;
        }
        if(root.left == null && root.right == null){
            String str = (char)(root.val + 'a') + s;
            ls.add(str);
            return;
        }
        
        solve(root.left, (char)(root.val + 'a') + s, ls);
        solve(root.right, (char)(root.val + 'a') + s, ls);
    }

}