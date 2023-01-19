public class soluiton
{
public static void changeTree(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        int child=0;
        if(root.left != null)
        {
            child += root.left.data;
        }
        if(root.right != null)
        {
            child += root.right.data;
        }
        if(child >= root.data) 
            root.data=child;
        else
        {
            root.left.data= root.data;
            root.right.data=root.data;
        }
        changeTree(root.left);
        changeTree(root.right);
        
        int total=0;
        if(root.left != null) total += root.left.data;
        if(root.right != null) total +=root.right.data;
        if(root.left != null || root.right != null) 
        {
            root.data=total;
        }
    }
}