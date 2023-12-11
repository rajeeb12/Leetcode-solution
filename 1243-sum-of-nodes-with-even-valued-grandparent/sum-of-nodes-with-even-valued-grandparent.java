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
class Tuple{
    TreeNode node;
    int parent;
    int grandParent;
    public Tuple(TreeNode _n,int _p,int _g)
    {
        this.node = _n;
        this.parent = _p;
        this.grandParent = _g; 
    }
}
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;

        Queue<Tuple> q= new LinkedList<>();
        q.add(new Tuple(root,-1,-1));
        
        int sum = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                Tuple t = q.poll();
                TreeNode node= t.node;
                int parent = t.parent;
                int grandParent = t.grandParent;

                if(grandParent % 2 == 0) sum += node.val;

                if(node.left != null)
                {
                    q.add(new Tuple(node.left, node.val, parent));
                }
                if(node.right != null)
                {
                     q.add(new Tuple(node.right, node.val, parent));
                }
            } 
        }
        return sum;
    }
}