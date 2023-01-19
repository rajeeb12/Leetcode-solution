/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        ArrayList<Integer> ans= new ArrayList<>();
        findPath(A,B,ans);
        int[] res= new int[ans.size()];
        if(A==null)
        {
            return res;
        }
        for(int i=0; i<ans.size(); i++)
        {
            res[i]=ans.get(i);
        }
        return res;
    }
    public static boolean findPath(TreeNode node,int n,ArrayList<Integer> ans)
    {
        if(node==null)
        {
            return false;
        }
        ans.add(node.val);
        if(node.val==n)
        {
            return true;
        }

        if( findPath(node.left,n,ans) || findPath(node.right,n,ans))
        {
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
        
    }
}
