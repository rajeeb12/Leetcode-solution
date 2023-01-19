class Solution{
    public TreeNode inorderSucceor(TrreNode root, int val)
    {
        TreeNode successor= null;
        TreeNode cur= root;
        while(cur != null)
        {
            if(cur.val > val)
            {
                successor =cur;
                cur= cur.left;
            }
            else{
                cur = cur.right;
            }
        }
        return successor;   
    }
}