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
    int vertical;
    int level;
    TreeNode node;
    public Tuple(int _v, int _l, TreeNode _n){
        this.vertical = _v;
        this.level = _l;
        this.node = _n;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //TreeMap<vertical,TreeMap<level,priorityQueue>

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,0,root));

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                Tuple temp = q.poll();
                int vertical = temp.vertical;
                int level = temp.level;
                TreeNode node = temp.node;

                if(!map.containsKey(vertical)){
                    map.put(vertical , new TreeMap<>());
                } 
                if(!map.get(vertical).containsKey(level)){
                    map.get(vertical).put(level, new PriorityQueue<>());
                }
                map.get(vertical).get(level).add(node.val);

                if(node.left != null) q.add(new Tuple(vertical - 1, level + 1, node.left));
                if(node.right != null) q.add(new Tuple(vertical + 1, level + 1, node.right));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> first: map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> pq : first.values()){
                while(!pq.isEmpty()){
                    temp.add(pq.poll());
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}