class Node{
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int _key,int _value){
        this.key = _key;
        this.value = _value;
        prev = null;
        next = null;
    }
}
class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    Node dummy;
    int capacity;
    public LRUCache(int _capacity) {
        this.capacity = _capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curNode = map.get(key);
        remove(curNode);
        insert(curNode, key);
        return curNode.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node dup = map.get(key);
            dup.value = value;
            remove(dup);
            insert(dup, dup.key);
        }else{
            Node newNode = new Node(key, value);
            if(map.size() >= capacity){
                remove(tail.prev);
            }
            insert(newNode, key);
        }
    }
    public void insert(Node node,int key){
        Node next = head.next;
        head.next = node;
        next.prev = node;
        node.next = next;
        node.prev = head;
        map.put(key, node);
        return;
    }
    public void remove(Node node){
        Node next = node.next;
        Node prev = node.prev;
        next.prev = prev;
        prev.next = next;
        node.next = null;
        node.prev = null;
        map.remove(node.key);
        return;
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */