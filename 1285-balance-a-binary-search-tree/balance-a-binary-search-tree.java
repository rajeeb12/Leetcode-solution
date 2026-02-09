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
    public TreeNode balanceBST(TreeNode root) {
        if(root == null) return root;

        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return createTree(list,0, list.size() - 1);
    }

    public TreeNode createTree(List<Integer> list, int l,int r){
        if(l > r) return null;
        int mid = (l + r) >> 1;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = createTree(list, l, mid - 1);
        node.right = createTree(list, mid + 1, r);

        return node;
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}