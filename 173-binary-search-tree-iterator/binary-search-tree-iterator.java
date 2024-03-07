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
class BSTIterator {
    int index;
    List<Integer> inorder;
    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<>();
        dfs(root,inorder);  
        index = 0;
    }
    public void dfs(TreeNode root, List<Integer> ls)
    {
        if(root == null) return;

        dfs(root.left, ls);
        ls.add(root.val);
        dfs(root.right, ls);
    }
    
    public int next() {
        return inorder.get(index++);
    }
    
    public boolean hasNext() {
        if(index == inorder.size()) return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */