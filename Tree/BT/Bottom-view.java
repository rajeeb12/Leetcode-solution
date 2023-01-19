/*********************************************

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

*********************************************/

import java.util.*;
class Pair{
    BinaryTreeNode node;
    int vertical;
    Pair(BinaryTreeNode node,int vertical)
    {
        this.node= node;
        this.vertical= vertical;
    }
}
public class Solution {
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        TreeMap<Integer,Integer> map= new TreeMap<>();
        Queue<Pair> q= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        if(root==null)
            return ans;
        
        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair temp= q.poll();
            BinaryTreeNode node= temp.node;
            int vertical= temp.vertical;
            
            if(!map.containsKey(vertical))
            {
                map.put(vertical,node.val);
            }
            else
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
            ans.add(entry.getValue());
        }
        return ans;
    }
}
