class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int _k,int _v)
    {
        this.key = _k;
        this.value = _v;
        prev = null;
        next = null;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = capacity;
    }
    
    public int get(int key) 
    {
        if(map.containsKey(key))
        {
            Node node = map.remove(key);
            remove(node);
            insert(new Node(key, node.value));
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.remove(key));
        }
        if(map.size() >= size){
            Node node = tail.prev;
            map.remove(node.key);
            remove(node);
        }
        insert(new Node(key, value));
    }
    public void insert(Node node)
    {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.next.prev = node;
        node.prev = head;
        map.put(node.key, node);
    }
    public void remove(Node node)
    {

        Node next = node.next;
        Node prev = node.prev;
        node.next.prev = prev;
        node.prev.next = next;
        node.prev = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */