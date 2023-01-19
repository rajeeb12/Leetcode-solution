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
    int level;
    Pair(TreeNode node,int level)
    {
        this.node=node;
        this.level=level;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        
        if(root==null)
            return ans;
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair temp= q.poll();
            TreeNode node= temp.node;
            int level= temp.level;
            
            if(!map.containsKey(level))
            {
                map.put(level,node.val);
            }
            if(node.right != null) 
                q.offer(new Pair(node.right,level+1));
            
            if(node.left != null) 
                q.offer(new Pair(node.left,level+1));
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}