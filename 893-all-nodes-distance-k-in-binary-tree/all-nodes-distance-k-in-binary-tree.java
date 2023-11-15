/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        // first bfs nad populating hashmap to store node and its parent
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root); 

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();

                if(node.left != null){ 
                    q.add(node.left);
                    map.put(node.left, node);
                }
                if(node.right != null){
                    q.add(node.right); 
                    map.put(node.right, node);
                }
            }
        }
        // second bfs to traverse tree in three direction + calculating level(distance)
        Queue<TreeNode> q1 = new LinkedList<>();

        HashSet<TreeNode> set= new HashSet<>(); // to keep track of visited nodes
        int distance = 0;
        q1.add(target);
        set.add(target);

        while(!q1.isEmpty()){
            int size = q1.size();

            if(distance == k){
                break;
            }
            for(int i= 0 ; i < size ; i++){
                TreeNode node = q1.poll();
                TreeNode parentNode = map.get(node);
                if(node.left != null && !set.contains(node.left)){
                    q1.add(node.left);
                    set.add(node.left);
                } 
                if(node.right != null && !set.contains(node.right)){    
                    q1.add(node.right);
                    set.add(node.right);
                } 
                if(parentNode != null && !set.contains(parentNode)){
                    set.add(parentNode);
                    q1.add(parentNode);
                }
            }
            distance++;
        }
        int size = q1.size();
        for(int i = 0 ; i < size ; i++){
            TreeNode node = q1.poll();
            ans.add(node.val);
        }
        return ans;
    }
}