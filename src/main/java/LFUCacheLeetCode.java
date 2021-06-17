import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCacheLeetCode {

    static class Item implements Comparable<Item>{
        int key;
        Integer counter = 1;
        int value;
        Long timestamp = 1l;

        public Item(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            if(this.counter == o.counter){
                return this.timestamp.compareTo(o.timestamp);
            }
            return this.counter.compareTo(o.counter);
        }
    }

    Map<Integer, Item> cache;
    PriorityQueue<Item> minHeap;
    final int MAX_SIZE;
    long counter = 0;
    int size = 0;

    public LFUCacheLeetCode(int capacity) {
        this.MAX_SIZE = capacity;
        if(this.MAX_SIZE == 0){
            return;
        }
        this.minHeap = new PriorityQueue<>(this.MAX_SIZE);
        this.cache = new HashMap<>(this.MAX_SIZE);
    }

    public int get(int key) {
        if(this.MAX_SIZE == 0){
            return -1;
        }
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            item.counter +=1;
            item.timestamp = ++counter;
            return item.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.MAX_SIZE == 0){
            return;
        }
        if(this.cache.containsKey(key)){
            Item item = this.cache.get(key);
            item.counter +=1;
            item.timestamp = ++counter;
            item.value = value;
        }else{
            if(this.size == this.MAX_SIZE){
                this.minHeap.clear();
                this.minHeap.addAll(this.cache.values());
                this.cache.remove(this.minHeap.remove().key);
                this.size -= 1;
            }
            Item item = new Item(key, value);
            item.timestamp = ++counter;
            this.size += 1;
            this.cache.put(key, item);
            this.minHeap.add(item);
        }
    }
}
