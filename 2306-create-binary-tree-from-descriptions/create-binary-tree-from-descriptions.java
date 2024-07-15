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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int d[]: descriptions){
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];
            TreeNode node =null;
            if(map.containsKey(parent)){
                node = map.get(parent);
            }else{
                node = new TreeNode(parent);
                map.put(parent, node);
            }
            set.add(child);
            TreeNode c= null;
            if(map.containsKey(child))
            {
                c = map.get(child);
            }else{
                c = new TreeNode(child);
                map.put(child, c);
            }
            if(isLeft == 1){
                node.left = c;
            }else{
                node.right = c;
            }
        }

        TreeNode root=null;

        for(int d[]: descriptions)
        {
            if(!set.contains(d[0])){
                root = map.get(d[0]);
                break;
            }
        }
        return root;
    }
}