class LRUCache {
    static class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hm;
    private int cap;
    public LRUCache(int cap) {
        this.cap = cap;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        hm = new HashMap<>();        
    }
    public void delete(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

    }
    public void insert(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) return -1;
        Node node = hm.get(key);        
        delete(node);
        insert(node);
        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node node = hm.get(key);
            node.val = value;
            hm.put(key, node);
            delete(node);
            insert(node);
        }
        else {
            if(hm.size() == cap) {
                Node lastNode = tail.prev;
                delete(lastNode);
                hm.remove(lastNode.key);
            }
            Node newNode = new Node(key, value);
            hm.put(key, newNode);
            insert(newNode);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */