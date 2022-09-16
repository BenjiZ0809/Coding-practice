class LRUCache {
    int capacity;
    Map<Integer, Node> map;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }
    
    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void insert(Node node) {
        Node prev = right.prev;
        node.prev = prev;
        right.prev = node;
        prev.next = node;
        node.next = right;
    }
    
    
    public int get(int key) {
        if(map.containsKey(key)) {
            this.remove(map.get(key));
            this.insert(map.get(key));
            return map.get(key).val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key, value);
        if(map.containsKey(key)) {
            this.remove(map.get(key));
        }
        map.put(key, newNode);
        this.insert(map.get(key));
        
        if(this.map.size() > this.capacity) {
            Node lru = left.next;
            this.remove(lru);
            map.remove(lru.key);
        }
    }
    
    class Node {
        int val;
        int key;
        Node prev;
        Node next;
        
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
