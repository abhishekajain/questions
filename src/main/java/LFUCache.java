import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {
	
	PriorityQueue<Item> minHeap;
	Map<Integer, Item> cache;
	int capacity;
	int size = 0;
	int timestamp = 0;
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<Integer, Item>();
		this.minHeap = new PriorityQueue<Item>(capacity);		
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			Item item = cache.get(key);
			item.frequency++;
			item.timestamp = ++this.timestamp;
			return item.val;
		}		
		return -1;
	}
	public void put(int key, int val) {
		if(cache.containsKey(key)) {
			Item item = cache.get(key);
			item.val = val;
			item.frequency++;
			item.timestamp = ++this.timestamp;
			return;
		}
		
		Item item = new Item();
		item.key = key;
		item.val = val;
		item.frequency = 1;
		item.timestamp = ++this.timestamp;
		if(this.capacity == this.size) {
			minHeap.clear();
			minHeap.addAll(cache.values());
			int evictKey = minHeap.poll().key;
			cache.remove(evictKey);
			this.size--;
		}
		cache.put(key, item);
		this.size++;		
	}
	
	static class Item implements Comparable<Item>{
		int key;
		int val;
		int frequency;
		int timestamp;
		
		public int compareTo(Item item) {
			if(item.frequency == this.frequency) {
				return item.timestamp - this.timestamp;
			}
			return item.frequency - this.frequency;
		}
	}

}
