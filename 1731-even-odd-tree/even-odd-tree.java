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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEvenIndexed = true;
        while(!q.isEmpty())
        {
            int size = q.size();
            int prev = -1;
            for(int i = 0 ; i < size; i++)
            {
                TreeNode node = q.poll();
                if(isEvenIndexed)
                {
                    if(node.val % 2 == 0) return false;
                    if(prev != -1 && node.val <= prev){
                        return false;
                    }
                }else{
                    if(node.val % 2 != 0) return false;
                    if(prev != -1 && node.val >= prev){
                        return false;
                    }
                }
                prev = node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            isEvenIndexed = !isEvenIndexed;
        }
        return true;
    }
}