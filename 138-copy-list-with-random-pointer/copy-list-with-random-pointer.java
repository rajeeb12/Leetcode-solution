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
        Node dummy = new Node(0);
        Node cur = dummy;
        HashMap<Node, Node> map = new HashMap<>();

        while(head != null){
            if(!map.containsKey(head)){
                map.put(head, new Node(head.val));
            }
            Node next = head.next;
            Node random = head.random;
            Node node = map.get(head);
            if(next != null && !map.containsKey(next)){
                map.put(next, new Node(next.val));
            }
            if(random != null && !map.containsKey(random)){
                map.put(random, new Node(random.val));
            }
            cur.next = node;
            cur = node;
            if(next != null) cur.next = map.get(next);
            if(random != null) cur.random = map.get(random);
            head = next;
        }
        return dummy.next;
    }
}