import java.util.HashMap;
import java.util.Map;


public class LFUCacheArray {

    Map<Integer, Item> cache = null;
    Item[] heap = null;
    int capacity = 0;
    int size = 0;
    int times = 0;

    public LFUCacheArray(int capacity) {
        this.cache = new HashMap<Integer, Item>(capacity);
        this.heap = new Item[capacity];
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.capacity == 0){
            return -1;
        }
        if(this.cache.containsKey(key)) {
            Item item  = this.cache.get(key);
            item.frequency++;
            item.timestamp = ++this.times;
            this.heapify(item.index);
            return item.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(this.capacity == 0){
            return;
        }
        if(this.cache.containsKey(key)) {
            Item item  = this.cache.get(key);
            item.value = value;
            item.frequency++;
            item.timestamp = ++this.times;
            this.heapify(item.index);
        }else {
            if(this.isFull()) {
                Item item = this.removeHead();
                this.cache.remove(item.key);
            }
            Item item = new Item();
            item.key = key;
            item.value = value;
            item.timestamp = ++this.times;
            this.insert(item);
            this.cache.put(key, item);
        }
    }


    private void heapify(int index) {
        if(this.heap[index].compareTo(this.heap[this.getParent(index)]) < 0) {
            this.fixHeapAbove(index);
        }else {
            this.fixHeapBelow(index, this.size-1);
        }
    }


    private void insert(Item item) {
        this.heap[this.size] = item;
        this.heap[this.size].index = this.size;
        this.fixHeapAbove(this.size++);
    }

    private Item removeHead() {
        Item item = this.heap[0];
        this.heap[0] = this.heap[--this.size];
        this.fixHeapBelow(0, this.size-1);
        return item;
    }

    private void fixHeapAbove(int index) {
        Item item = this.heap[index];
        while(index > 0) {
            int parentIndex = this.getParent(index);
//    		if parent is bigger move parent to index
            if(this.heap[parentIndex].compareTo(item) > 0) {
                this.heap[index] = this.heap[parentIndex];
                this.heap[index].index = index;
                index = parentIndex;
            }else {
                break;
            }
        }
        this.heap[index] = item;
        this.heap[index].index = index;
    }

    private void fixHeapBelow(int index, int lastIndex) {
        Item item = this.heap[index];
        while(index < lastIndex) {
            int leftChild = this.getChild(index, true);
            int rightChild = this.getChild(index, false);
            if(leftChild <= lastIndex && rightChild <= lastIndex) {
                int replaceIndex = this.heap[leftChild].compareTo(this.heap[rightChild])<0?leftChild:rightChild;
                if(item.compareTo(this.heap[replaceIndex]) > 0 ) {
                    this.heap[index] = this.heap[replaceIndex];
                    this.heap[index].index = index;
                    index = replaceIndex;
                }else {
                    break;
                }
            }else if (leftChild <= lastIndex) {
                if(item.compareTo(this.heap[leftChild]) > 0 ) {
                    this.heap[index] = this.heap[leftChild];
                    this.heap[index].index = index;
                    index = leftChild;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        this.heap[index] = item;
        this.heap[index].index = index;
    }

    private int getParent(int index) {
        return (index-1)/2;
    }

    private int getChild(int index, boolean left) {
        return 2*index + (left?1:2);
    }

    public boolean isFull() {
        if(this.size == this.capacity) {
            return true;
        }
        return false;
    }

    class Item implements Comparable<Item>{

        int key;
        int value;
        int frequency;
        int timestamp;
        int index;

        @Override
        public int compareTo(Item o) {
            if(this.frequency == o.frequency) {
                return this.timestamp - o.timestamp;
            }
            return this.frequency - o.frequency;
        }

        @Override
        public String toString() {
            return "Item [key=" + key + ", value=" + value + ", frequency=" + frequency + ", timestamp=" + timestamp + ", index=" + index + "]";
        }

    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

