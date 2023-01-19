/*

	Following is the structure used to represent the Binary Tree Node

	class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

*/

import java.util.ArrayList;

class pair{
    BinaryTreeNode node;
    int num;
    Pair(BinartTeeNode node,int num)
    {
        this.node=node;
        this.num=num;
    }
}
public class Solution {

  public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
      Stack<Pair> stack= new Stack<>();
      stack.push(new Pair(root,1));
      List<Integer> preorder= new ArrayList<>();
      List<Integer> Inorder= new ArrayList<>();
      List<Integer> postorder= new ArrayList<>();
      
      while(!stack.isEmpty())
      {
          Pair temp= stack.peek();
          
          if(temp.num==1)
          {
              preorder.add(temp.node.data);
              temp.num++;
              stack.push(temp);
              if(temp.node.left != null) stack.push(new Pair(temp.node.left,1));
          }
          else if(temp.num==2)
          {
              inorder.push(temp.node.data);
              temp.num++;   
              stack.push(temp);
              if(temp.node.right != null) stack.push(new Pair(temp.node.right,1));
          }
          else
          {
              post.add(temp.node.data);
              stack.pop();
          }
      }
  }

}