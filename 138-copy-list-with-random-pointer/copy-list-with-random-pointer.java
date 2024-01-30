/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);

        Node cur = head.next;
        Node newcur = newHead;

        while(cur != null)
        {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            
            newcur.next = newNode;
            newcur = newcur.next;
            cur = cur.next;
        }
        cur = head;
        newcur = newHead;

        while(cur != null)
        {
            newcur.random = map.getOrDefault(cur.random, null);
            cur = cur.next;
            newcur = newcur.next; 
        } 
        return newHead;
    }
}