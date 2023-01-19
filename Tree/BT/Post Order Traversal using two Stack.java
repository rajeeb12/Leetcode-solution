class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Stack<TreeNode> stack1= new Stack<>();
        Stack<TreeNode> stack2= new Stack<>();
        
        stack1.push(root);
        while(!stack1.isEmpty())
        {
            TreeNode node= stack1.pop();
            stack2.push(node);
            if(node.left != null) stack1.push(node.left);
            
            if(node.right != null) stack1.push(node.right);
        }
        while(!stack2.isEmpty())
        {
            ans.add(stack2.pop().val);
        }
        return ans;
    }
}