class Node{
    int num;
    Node next;
    public Node(int _num){
        this.num = _num;
        next = null;
    }
}
class Solution {
    public int findTheWinner(int n, int k) {
        if(k == 1) return n;

        Node head= new Node(1);
        Node cur = head;
        for(int i = 2; i <= n; i++){
            Node node = new Node(i);
            cur.next = node;
            cur = node; 
        }
        cur.next = head;
        return solve(head, k);
    }
    public int solve(Node head, int k){
        Node cur = head;
        int ans = 0;
        while(cur.next != cur)
        {
            Node prev = null;
            for(int i = 1; i < k; i++){
                prev = cur;
                cur = cur.next;
            }
            if(prev == cur){
                cur = cur.next;
            }
            prev.next = cur.next;
            cur = cur.next;
        }
        return cur.num;
    }
}