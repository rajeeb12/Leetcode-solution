/**********************************************************	
	
	Following is the representation of Binary Tree Node:
 	
 	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;
		
		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}

*********************************************************/

public class Solution
{
    public static BinaryTreeNode<Integer> parentChild(BianryTreNode<Integer> root,Map<BinaryTreeNode<Integer>,BinaryTreeNode<Integer>> map,int start )
    {
        Queue<BinaryTreeNode<Integer>> q= new LinkedList<>();
        q.offer(root);
        BinaryTreeNode<Integer> res= new BinaryTreeNode<>(-1);
        while(!q.isEmpty())
        {
            TreeNode node= q.poll();
            if(node.val == start)
            {
                res= node;
            }
            if(node.left != null)
            {
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right != null)
            {
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
    
public static int timeToBurnTree(BinaryTreeNode<Integer> root, int start)
    {
        Map<BinaryTreeNode, BinaryTreeNode> map= new HashMap<>();
        Queue<BianryTreeNode<Integer>> q= new LinkedList<>();
        BinaryTrreNode<Integer> node= parentChild(root,map,start);//O(N)
        Map<BinaryTreeNode, Boolean> visited= new HashMap<>();
        q.offer(root); 
        visited.put(node,true);
        int TimeToBurn=0;
        while(!q.isEmpty())
        {
            int size= q.size();
            int flag =0; 
            for(int i=0; i<size; i++)
            {
                TreeNode temp= q.poll();
                if(temp.left != null && visited.get(temp.left)==null)
                {
                    flag =1; //it means I have burned r
                    q.offer(temp.left);
                    visited.put(temp.left,true);
                }
                if(temp.right != null && visited.get(temp.right)==null)
                {
                    flag=1;
                    q.offer(temp.right);
                    visited.put(temp.right,true);
                }
                if(map.get(temp) != null && visited.get(map.get(temp))==null)
                {
                    flag=1;
                    q.offer(map.get(temp));
                    visited.put(map.get(temp));
                }
            }
            if(flag==1)
            {
                TimeToBurn++;
            }
        }
    return TimeToBurn;
    }
}