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
    public int countPairs(TreeNode root, int distance) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        List<TreeNode> ls = new ArrayList<>();
        create(root, map,ls);
        int ans = 0;
        for(TreeNode node: ls)
        {
            ans += bfs(node, map, distance);
        }
        return ans/2;
    }
    public int bfs(TreeNode node, HashMap<TreeNode, TreeNode> map,int distance){
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);
        set.add(node);
        int level = 0;
        
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode root = q.poll();

                if(level <= distance)
                {
                    if(root != node && root.left == null && root.right == null) count++; 
                } 

                if(map.get(root) != null && !set.contains(map.get(root)))
                {
                    set.add(map.get(root));
                    q.add(map.get(root));
                }
                if(root.left != null && !set.contains(root.left))
                {
                    set.add(root.left);
                    q.add(root.left);
                }
                if(root.right != null && !set.contains(root.right))
                {
                    set.add(root.right);
                    q.add(root.right);
                }
            } 
            level++;
            if(level > distance) break;
        }
        return count;
    }
    public void create(TreeNode root, HashMap<TreeNode, TreeNode> map, List<TreeNode> ls){
        if(root == null) return;

        if(root.left == null && root.right == null) ls.add(root);

        if(root.left != null)
        {
            map.put(root.left, root);
            create(root.left, map, ls);
        }
        if(root.right != null)
        {
            map.put(root.right, root);
            create(root.right, map, ls);
        }
    }
}