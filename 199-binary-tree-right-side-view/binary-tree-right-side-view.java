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
    int level;
    TreeNode node;
    public Pair(int _l, TreeNode _n){
        this.level = _l;
        this.node = _n;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<Integer> res= new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        if(root== null) return res;

        q.add(new Pair(0,root));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i= 0 ; i < size ;i++){
                Pair temp = q.poll();
                int level = temp.level;
                TreeNode node = temp.node;

                map.put(level, node.val);
                if(node.left != null) q.add(new Pair(level + 1 , node.left));
                 if(node.right != null) q.add(new Pair(level + 1 , node.right));
            }
        }
        for(int value : map.values()){
            res.add(value);
        }
        return res;
    }
}