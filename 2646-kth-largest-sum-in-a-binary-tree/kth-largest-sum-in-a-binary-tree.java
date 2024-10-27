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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            Long sum = 0L;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

            }
            pq.add(sum);
            if(pq.size() > k) pq.poll();
        } 
        return (pq.size() < k ? -1 : pq.poll());
    }
}