import java.util.HashMap;
import java.util.Map;

class LRUCacheLeetCode {

    int size = 0;
    int capacity = 0;
    Map<Integer, Node> cache = null;

    Node front;
    Node rear;


    public LRUCacheLeetCode(int capacity) {
        this.cache = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.cache.containsKey(key)) {
            Node node  = this.cache.get(key);
            this.addToFront(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            Node node  = this.cache.get(key);
            node.value = value;
            this.addToFront(node);
        }else {
            if(this.isFull()) {
                Node node = this.removeFromRear();
                this.cache.remove(node.key);
                this.size--;
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            this.addToFront(node);
            this.cache.put(key, node);
            this.size++;
        }
    }

    public boolean isFull() {
        if(this.size == this.capacity) {
            return true;
        }
        return false;
    }

    private void addToFront(Node node) {
        if(this.front == node) {
            return;
        }
        if(this.front == null) {
            this.front = node;
            this.rear = node;
            return;
        }
        if(node.previous != null) {
            node.previous.next = node.next;
        }
        if(node.next != null) {
            node.next.previous = node.previous;
        }
        node.next = this.front;
        if(node == this.rear) {
            this.rear = node.previous;
        }
        node.previous = null;
        this.front.previous = node;
        this.front = node;

    }

    private Node removeFromRear() {
        if(this.front == this.rear) {
            Node temp = this.front;
            this.front = null;
            this.rear = null;
            return temp;
        }
        Node temp = this.rear;
        this.rear = this.rear.previous;
        this.rear.next = null;
        return temp;
    }



    class Node{
        int key;
        int value;
        Node next;
        Node previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */