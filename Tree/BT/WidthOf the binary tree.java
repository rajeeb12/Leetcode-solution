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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node, int index)
    {
        this.node= node;
        this.index= index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q= new LinkedList<>();
        if(root==null)
        {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        q.offer(new Pair(root,0));
        
        while(!q.isEmpty())
        {
            int min= q.peek().index;
            int size= q.size();
            int first=0,last=0;
            for(int i=0; i<size; i++)
            {
                Pair temp= q.poll();
                int current= temp.index-min; // calculating for each node.
                TreeNode node= temp.node;
                
                if(i==0) first= current;
                if(i==size-1) last= current;
                
                if(node.left != null) q.offer(new Pair(node.left,current*2+1));
                if(node.right != null) q.offer(new Pair(node.right,current*2+2));
            }
            ans= Math.max(ans,last-first+1);
        }
        return ans;
    }
}