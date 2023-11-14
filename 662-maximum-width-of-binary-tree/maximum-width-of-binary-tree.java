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
    int num;
    TreeNode node;
    public Pair(int n, TreeNode _n){
        this.num = n;
        this.node = _n; 
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q= new LinkedList<>();
        int res = 0;

        q.add(new Pair(0,root));
        while(!q.isEmpty())
        {
            int size = q.size();
            int min = q.peek().num;
            int first = 0 , last = 0;
            for(int i = 0 ; i < size ; i++){
                Pair temp = q.poll();
                int index = temp.num;
                TreeNode node =temp.node;
                int current_index = index - min;
                
                if(i == 0) first = current_index;
                if(i == size -1) last = current_index;

                if(node.left != null) q.add(new Pair(2*current_index + 1, node.left));
                if(node.right != null) q.add(new Pair(2*current_index + 2, node.right));
            }
            res = Math.max(res, (last - first + 1));
        }
        return res;
    }
}