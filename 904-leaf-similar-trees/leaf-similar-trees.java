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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if(root1 == root2) return true;

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();
        getLeafNodeValues(root1, temp1);
        getLeafNodeValues(root2, temp2);

        if(temp1.size() != temp2.size()) return false;
        
        for(int i= 0 ; i < temp1.size(); i++)
        {
            if(temp1.get(i) != temp2.get(i)) return false;
        }
        return true;
    }
    public void getLeafNodeValues(TreeNode root,List<Integer> ls)
    {
        if(root == null) return;

        if(isLeaf(root)) ls.add(root.val);
        getLeafNodeValues(root.left, ls);
        getLeafNodeValues(root.right, ls);
    }
    public boolean isLeaf(TreeNode root)
    {
        if(root.left == null && root.right == null) return true;
        return false;
    }
}