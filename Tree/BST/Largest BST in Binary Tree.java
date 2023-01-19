// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class NodeValue{
    int maxNode, minNode, maxSize;
    public NodeValue(int minNode,int maxNode,int maxSize)
    {
        this.maxNode= maxNode;
        this.minNode= minNode;
        this.maxSize= maxSize;
    }
}
class solution {
    private NodeValue largetBSTSubTreeHelper(TreeNode root) {
        if(root==null)
        {
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        NodeValue left= largestBSTSubTreeHelper(root.left);
        NodeValue right= largestBSTSubTreeHelper(root.right);
        
        if((left.maxNode < root.val) && (root.val < right.minNode))
        {
            return new NodeValue(Math.min(root.val,left.minNode),Math.max(right.maxNode,root.val),left.maxSize + right.maxSize +1);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
        
    }
    public int largestBSTSubTree(TreeNode root)
    {
        return largestBSTSubTreeHelper(root).maxSize;
    }
}