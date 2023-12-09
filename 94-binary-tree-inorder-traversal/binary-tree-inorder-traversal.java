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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while(true)
        {
            if(cur != null)
            {
                st.add(cur);
                cur = cur.left;
            }
            else{
                if(st.isEmpty()) break;
                TreeNode node = st.pop();
                ans.add(node.val);
                cur = node.right;
            }
        }
        return ans;
    }
}