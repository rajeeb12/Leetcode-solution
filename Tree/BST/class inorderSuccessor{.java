class inorderSuccessor{
    public static TreeNode inorderSuccessor(TreeNode root,int value)
    {
        if(root==null)
        {
            return null;
        }

        TreeNode successor= null;
        while(root != null)
        {
            if(root.val > value)
            {
                successor= root;
                root= root.left;
            }
            else{
                root= root.right;
            }
        }
        return root;
    }
}