/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/
import java.util.*;
class Pair{
    BinaryTreeNode node;
    int vertical;
    Pair(BinaryTreeNode node,int data)
    {
        this.node=node;
        this.vertical=data;
    }
}
public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        ArrayList<Integer> res= new ArrayList<>();
        if(root==null)
            return res;
        
        q.offer(new Pair(root,root.val));
        
        while(!q.isEmpty())
        {
            Pair temp= q.poll();
            BinaryTreeNode node= temp.node;
            int vertical= temp.vertical;
            
            if(!map.containsKey(vertical))
            {
                map.put(vertical,node.val);
            }
            if(node.left != null)
                q.offer(new Pair(node.left,vertical-1));
            if(node.right != null)
                q.offer(new Pair(node.right,vertical+1));
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            res.add(entry.getValue());
        }
        return res;
	}
}