/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        String res="";
    //level-order
        while(!q.isEmpty()){
            int size= q.size();

            for(int i = 0 ; i < size ; i++){
                TreeNode node = q.poll();
                if(node == null){
                    res += "# " ; // zaruri hai
                    continue;
                }
                res += node.val + " ";
                q.add(node.left);
                q.add(node.right);
            }
        }
        System.out.print(res);
        
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        int n = data.length();
        String values[]= data.split(" ");
        Queue<TreeNode> q= new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        q.add(root);

        for(int i = 1 ; i < values.length ; i++){
            TreeNode node = q.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));