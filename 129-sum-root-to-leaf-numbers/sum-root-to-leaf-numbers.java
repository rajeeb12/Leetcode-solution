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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        ArrayList<String> ans = new ArrayList<>();
        solve(root, "", ans);
        int res = 0;

        for(String s : ans){
            System.out.print(s+" ");
            res += Integer.parseInt(s);
        }
        return res;
    }
    public void solve(TreeNode root,String str,ArrayList<String> ans)
    {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            str += root.val;
            ans.add(str); 
            return;
        }

        solve(root.left,str + root.val, ans);
        solve(root.right, str + root.val, ans);
    }
}