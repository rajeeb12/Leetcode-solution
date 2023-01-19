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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Stack<TreeNode> stack= new Stack<>();
        
        TreeNode cur= root;
        while(cur!=null || !stack.isEmpty())
        {
            if(cur!=null)
            {
                stack.push(cur);
                cur= cur.left;
            }
            else
            {
                TreeNode temp = stack.peek().right;
                if(temp==null)
                {
                    temp = stack.peek();
                    stack.pop();
                    ans.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right)
                    {
                        temp = stack.peek();
                        stack.pop();
                        ans.add(temp.val);
                    }
                }
                else
                {
                    cur = temp;
                }
            }
        }
        r       eturn ans;
        
    }
}