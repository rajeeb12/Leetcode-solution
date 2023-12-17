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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder= new ArrayList<>();
        traversal(root,inorder);

        int left = 0, right = inorder.size() - 1;

        while(left < right)
        {
            int sum = inorder.get(left) + inorder.get(right);
            if(sum > k)
            {
                right--;
            }else if(sum < k){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
    public void traversal(TreeNode root, ArrayList<Integer> inorder)
    {
        if(root == null) return;

        traversal(root.left, inorder);
        inorder.add(root.val);
        traversal(root.right, inorder);
    }
}