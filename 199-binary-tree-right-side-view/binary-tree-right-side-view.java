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
    public Pair(int _l,TreeNode _n)
    {
        this.level = _l;
        this.node = _n;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            int level = temp.level;
            TreeNode node = temp.node;

            map.put(level, node.val);
            if(node.left != null)
            {
                q.add(new Pair(level + 1, node.left));
            }
            if(node.right != null)
            {
                q.add(new Pair(level + 1, node.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
}