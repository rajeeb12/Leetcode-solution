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
        StringBuilder str = new StringBuilder("");
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            if(node == null)
            {
                str.append("n ");
                continue;
            }
            str.append(node.val+" ");
            q.add(node.left);
            q.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        Queue<TreeNode> q= new LinkedList<>();
        String arr[] = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);

        for(int i = 1; i < arr.length; i++)
        {
            TreeNode parent = q.poll();
            if(!arr[i].equals("n"))
            {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.add(left);
            }
            if(!arr[++i].equals("n"))
            {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
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