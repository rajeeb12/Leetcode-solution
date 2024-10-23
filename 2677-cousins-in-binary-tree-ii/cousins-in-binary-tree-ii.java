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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<TreeNode> lsNodes = new ArrayList<>();
            int size = q.size();

            int nextLevelSum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                lsNodes.add(node);
                if(node.left != null){
                    nextLevelSum += node.left.val;
                    q.add(node.left);
                }
                if(node.right != null){
                    nextLevelSum += node.right.val;
                    q.add(node.right);
                }
            }
            for(TreeNode node: lsNodes){
                int sum = nextLevelSum;

                if(node.left != null){
                    sum -= node.left.val;
                }
                if(node.right != null){
                    sum -= node.right.val;
                }
                if(node.left != null){
                    node.left.val = sum; 
                }
                if(node.right != null){
                    node.right.val = sum; 
                }
            }
        }
        root.val = 0;
        return root;
    }
}