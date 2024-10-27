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
    HashMap<Integer,Integer> left;
    HashMap<Integer,Integer> right;
    HashMap<Integer,Integer> height;

    public int[] treeQueries(TreeNode root, int[] queries) {
        left = new HashMap<>();
        right = new HashMap<>();
        height = new HashMap<>();
        
        dfs(root);
        solve(root.left, right.get(root.val), 1);
        solve(root.right, left.get(root.val), 1);
        
        int ans[] = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            ans[i] = height.get(queries[i]);
        }
        return ans;
    }
    public void solve(TreeNode root,int maxHeight, int depth){
        if(root == null) return;

        height.put(root.val, maxHeight);
        solve(root.left, Math.max(maxHeight, depth + right.get(root.val)) , depth + 1);
        solve(root.right, Math.max(maxHeight, depth + left.get(root.val)) , depth + 1);
    }
    public int dfs(TreeNode root){
        if(root == null) return 0;

        int leftH = dfs(root.left);
        int rightH = dfs(root.right);

        left.put(root.val, leftH);
        right.put(root.val, rightH);

        return Math.max(leftH, rightH) + 1;
    }
}