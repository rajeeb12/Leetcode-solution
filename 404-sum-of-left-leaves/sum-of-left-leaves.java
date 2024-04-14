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
    int num;
    public Pair(TreeNode _n,int _nu){
        this.node = _n;
        this.num = _nu;
    } 
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> q =  new LinkedList();

        if(root.left == null && root.right ==  null) return 0;

        q.add(new Pair(root, -1));
        int ans = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair p = q.poll();

                if(p.num == 0 && (p.node.left == null && p.node.right == null)) ans += p.node.val;

                if(p.node.left != null) q.add(new Pair(p.node.left, 0));
                if(p.node.right != null) q.add(new Pair(p.node.right , 1));
            }
        }
        return ans;
    }
}