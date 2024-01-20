class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int k,int v)
    {
        this.key = k;
        this.val = v;
    }
}
class LRUCache {
    HashMap<Integer,Node> map;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);;
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
        if(!map.containsKey(key)) return -1;

        Node cur = map.get(key);
        remove(cur);
        insert(new Node(key ,cur.val));
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        if(map.size() == cap)
        {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
    public void remove(Node node)
    {
        map.remove(node.key);
        Node next = node.next;
        node.prev.next = next;
        node.next.prev = node.prev;
    }
    public void insert(Node newNode)
    {
        Node next = head.next;
        head.next = newNode;
        newNode.next = next;
        newNode.next.prev = newNode;
        newNode.prev = head;
        map.put(newNode.key,newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */