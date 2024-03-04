/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode _n,int _l)
    {
        this.node = _n;
        this.level = _l;
    }
}
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        createParentChildRel(root, map);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(target, 0));
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited= new HashSet<>();
        visited.add(target);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                Pair p = q.poll();
                TreeNode node = p.node;
                int curLevel = p.level;

                if(curLevel == k)
                {
                    ans.add(node.val);
                }
                if(node.left != null && !visited.contains(node.left))
                {
                    q.add(new Pair(node.left, curLevel + 1));
                    visited.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right))
                {
                    q.add(new Pair(node.right, curLevel + 1));
                    visited.add(node.right);
                }
                TreeNode parent = map.get(node);
                if(parent != null && !visited.contains(parent))
                {
                    q.add(new Pair(parent, curLevel + 1));
                    visited.add(parent);
                }
            }
        }
        return ans;
    }
    public void createParentChildRel(TreeNode root, HashMap<TreeNode, TreeNode> map)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root, null);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node.left != null)
            {
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
}