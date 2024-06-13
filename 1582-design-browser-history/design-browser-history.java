class Node{
    Node backward;
    String s;
    Node forward;
    public Node(String s){
        this.s = s;
    }
}
class BrowserHistory {
    Node root;
    public BrowserHistory(String homepage) {
        root = new Node(homepage);
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        root.forward = node;
        node.backward = root;
        root = root.forward; 
    }
    
    public String back(int steps) {
        while(root.backward != null && steps-- > 0){
            root = root.backward;
        }
        return root.s;
    }
    
    public String forward(int steps) {
        while(root.forward != null && steps-- > 0){
            root = root.forward;
        }
        return root.s;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */