 /************************************************************

    Following is the Binary Tree node structure:
    
   class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
		    this.data = data;
		    this.left = null;
		    this.right = null;
	    }

    }

************************************************************/

import java.util.ArrayList;
import java.util.*;
public class Solution {
    public static boolean isLeaf(TreeNode root)
    {
        if(root.left==null && root.right==null) return true;
        
        return false;
    }
    public static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans)
    {   
        TreeNode node=root.left;
        while(node!=null)
        {
            if(isLeaf(node)==false) ans.add(node.data);
            
            if(node.left!=null) 
                node= node.left;
            else
                node= node.right;
        }
    }
    public static void addLeaf(TreeNode root,ArrayList<Integer> ans)
    {
        if(isLeaf(root))
        {
            ans.add(root.data);
            return;
        }
        if(root.left != null) addLeaf(root.left,ans);
        if(root.right != null) addLeaf(root.right,ans);
    }
    public static void addRightBoundary(TreeNode root,ArrayList<Integer> ans)
    {
        TreeNode cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > ();
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            ans.add(tmp.get(i));
        }
    }
	public static ArrayList<Integer> traverseBoundary(TreeNode root){
		ArrayList<Integer> ans= new ArrayList<>();
        if(isLeaf(root)==false) ans.add(root.data);
        addLeftBoundary(root,ans);
        addLeaf(root,ans);
        addRightBoundary(root,ans);
        return ans;
	}
}