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
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        if(root == null) return;
        st = new Stack<>();
        while(root != null){
            st.add(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode node = st.pop();
        int ans = node.val;
        if(node.right != null){
            node = node.right;
            while(node != null){
                st.add(node);
                node= node.left;
            }
        }
        return ans;
    }
    
    public boolean hasNext() {
        return (!st.isEmpty() == false ?  false : true);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */