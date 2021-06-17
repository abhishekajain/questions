package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    private int capacity = 0;
    private int size = 0;
    private Queue<Integer> queue = null;
    private Map<Integer, Integer> cache = null;

    private Object lock = new Object();

    public LRUCache(Integer capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>(this.capacity);
        this.queue = new LinkedList<>();
    }

    public Integer get(Integer key){
        synchronized (lock) {
            if (this.cache.containsKey(key)) {
                this.queue.remove(key);
                this.queue.offer(key);
                return this.cache.get(key);
            }
        }
        return -1;
    }

    public void put(Integer key, Integer value){
        synchronized (lock) {
            if (this.cache.containsKey(key)) {
                this.queue.remove(key);
                this.queue.offer(key);
                this.cache.put(key, value);
            } else {
                if (this.capacity == this.size) {
                    this.cache.remove(this.queue.poll());
                    this.size--;
                }
                this.queue.offer(key);
                this.cache.put(key, value);
                this.size++;
            }
        }
    }
}
