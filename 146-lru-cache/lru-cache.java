class Node{
    Node prev;
    Node next;
    int key;
    int value;
    public Node(int _key,int _value){
        this.key = _key;
        this.value = _value;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1 , -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(key, node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insert(key, node);
        }else{
            if(map.size() >= capacity){
                remove(tail.prev);
            }
            Node newNode = new Node(key, value);
            insert(key, newNode);
        }
    }
    public void insert(int key,Node node){
        map.put(key, node);
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        map.remove(node.key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */