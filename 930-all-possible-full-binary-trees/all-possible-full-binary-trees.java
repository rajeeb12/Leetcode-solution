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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n % 2 == 0) return ans;
        if(n == 1)
        {
            TreeNode node = new TreeNode(0);
            ans.add(node);
            return ans;
        }
        return solve(n);
    }
    public List<TreeNode> solve(int n)
    {
        if(n == 1)
        {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(0));
            return ans;
        }
        List<TreeNode> ans = new ArrayList<>();
        for(int i = 1; i < n; i += 2)
        {
            List<TreeNode> left = solve(i);
            List<TreeNode> right = solve(n - i - 1);

            for(TreeNode l: left)
            {
                for(TreeNode r: right)
                {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}