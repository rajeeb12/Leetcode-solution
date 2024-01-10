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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode startNode = null;
        q.add(root);
        map.put(root, null);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size; i++)
            {
                TreeNode node = q.poll();
                if(node.val == start)
                {
                    startNode = node;
                }
                if(node.left != null){
                    q.add(node.left);
                    map.put(node.left, node);
                }
                if(node.right != null)
                {
                    q.add(node.right);
                    map.put(node.right, node);
                }
            }
        }
        if(startNode == null) return 0;
        HashSet<TreeNode> set = new HashSet<>();
        q.clear();

        q.add(startNode);
        set.add(startNode);

        int count = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0 ; i < size ; i++)
            {
                TreeNode node =q.poll();  
                System.out.print(node.val+" "+count);   

                if(map.get(node) != null && !set.contains(map.get(node)))
                {
                    set.add(map.get(node));
                    q.add(map.get(node));
                }
                if(node.left != null && !set.contains(node.left))
                {
                    set.add(node.left);
                    q.add(node.left);
                }
                if(node.right != null && !set.contains(node.right))
                {
                    set.add(node.right);
                    q.add(node.right);
                }
            }
            ++count;
        }
        return count - 1;
    }
}